package io.atruecooky.craftory.content.block;

import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;
import io.atruecooky.craftory.utils.BlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PipeBlock extends TransparentBlock {

	public static final MapCodec<PipeBlock> CODEC = BlockBehaviour.simpleCodec(PipeBlock::new);

	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	public static final BooleanProperty UP = BooleanProperty.create("up");
	public static final BooleanProperty DOWN = BooleanProperty.create("down");

	public static final VoxelShape SHAPE = BlockUtils.createShape(4, 4, 4, 8, 8, 8);

	public static final VoxelShape[] PART_SHAPES = {
		BlockUtils.createShape(4,  4,  0,  8, 8, 4),
		BlockUtils.createShape(12, 4,  4,  4, 8, 8),
		BlockUtils.createShape(4,  4,  12, 8, 8, 4),
		BlockUtils.createShape(0,  4,  4,  4, 8, 8),
		BlockUtils.createShape(4,  12, 4,  8, 4, 8),
		BlockUtils.createShape(4,  0,  4,  8, 4, 8)
	};
	
	@Override
	protected MapCodec<? extends PipeBlock> codec() {
		return CODEC;
	}

	public PipeBlock(BlockBehaviour.Properties properties) {
		super(properties
			.pushReaction(PushReaction.DESTROY)
			.noOcclusion()
		);
		this.stateDefinition.any()
			.setValue(NORTH, false)
			.setValue(EAST, false)
			.setValue(SOUTH, false)
			.setValue(WEST, false)
			.setValue(UP, false)
			.setValue(DOWN, false)
		;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		VoxelShape shape = SHAPE;
		if (state.getValue(NORTH)) shape = Shapes.or(shape, PART_SHAPES[0]);
		if (state.getValue(EAST)) shape = Shapes.or(shape, PART_SHAPES[1]);
		if (state.getValue(SOUTH)) shape = Shapes.or(shape, PART_SHAPES[2]);
		if (state.getValue(WEST)) shape = Shapes.or(shape, PART_SHAPES[3]);
		if (state.getValue(UP)) shape = Shapes.or(shape, PART_SHAPES[4]);
		if (state.getValue(DOWN)) shape = Shapes.or(shape, PART_SHAPES[5]);
		return shape;
	}

	@Override
	protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
		BooleanProperty property = getProperty(direction);
		if (state != null) {
			state = state.setValue(property, this.canConnectTo(neighborState));
		}
		return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		return this.defaultBlockState()
		.setValue(NORTH, canConnectTo(level.getBlockState(pos.north())))
		.setValue(EAST, canConnectTo(level.getBlockState(pos.east())))
		.setValue(SOUTH, canConnectTo(level.getBlockState(pos.south())))
		.setValue(WEST, canConnectTo(level.getBlockState(pos.west())))
		.setValue(UP, canConnectTo(level.getBlockState(pos.above())))
		.setValue(DOWN, canConnectTo(level.getBlockState(pos.below())))
		;
	}

	@Override
	protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
		return false;
	}

	public boolean canConnectTo(BlockState state) {
		return state.getBlock() instanceof PipeBlock;
	}

	@Override
	public boolean addLandingEffects(BlockState state1, ServerLevel level, BlockPos pos, BlockState state2, LivingEntity entity, int numberOfParticles) {
		return true;
	}

	@Override
	public boolean addRunningEffects(BlockState state, Level level, BlockPos pos, Entity entity) {
		return true;
	}
	
	public @Nullable BooleanProperty getProperty(Direction direction) {
		switch (direction) {
			case NORTH: return NORTH;
			case EAST: return EAST;
			case SOUTH: return SOUTH;
			case WEST: return WEST;
			case UP: return UP;
			case DOWN: return DOWN;
			default: return null;
		}
	}

}
