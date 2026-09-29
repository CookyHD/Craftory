package io.atruecooky.craftory.content.block;

import com.mojang.serialization.MapCodec;

import io.atruecooky.craftory.content.block_entity.SmelterEntity;
import io.atruecooky.craftory.register.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;

public class SmelterBlock extends Block implements EntityBlock {
	
	public static final MapCodec<SmelterBlock> CODEC = BlockBehaviour.simpleCodec(SmelterBlock::new);

	@Override
	protected MapCodec<SmelterBlock> codec() {
		return CODEC;
	}

	public static final DirectionProperty FACEING = DirectionProperty.create("faceing");
	public static final BooleanProperty PROCESSING = BooleanProperty.create("processing");
	public static final BooleanProperty FUELED = BooleanProperty.create("fueled");
	
	public SmelterBlock(Properties properties) {
		super(properties
			.pushReaction(PushReaction.BLOCK)
			.lightLevel((state) -> state.getValue(FUELED) ? 13 : 0)
		);
		this.stateDefinition.any()
			.setValue(FACEING, Direction.NORTH)
			.setValue(PROCESSING, false)
			.setValue(FUELED, false)
		;
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level getterLevel, BlockState getterState, BlockEntityType<T> blockEntityType) {
		if (getterLevel.isClientSide()) return (level, pos, blockState, blockEntity) -> SmelterEntity.tickClient(level, pos, blockState, (SmelterEntity)blockEntity);
		return (level, pos, blockState, blockEntity) -> SmelterEntity.tickServer((ServerLevel)level, pos, blockState, (SmelterEntity)blockEntity);
	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if (state.getValue(FUELED)) {
			
		}
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACEING, PROCESSING, FUELED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACEING, context.getPlayer().isShiftKeyDown() ? context.getHorizontalDirection() : context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SmelterEntity(ModBlockEntityTypes.SMELTER.get(), pos, state);
	}
	
}
