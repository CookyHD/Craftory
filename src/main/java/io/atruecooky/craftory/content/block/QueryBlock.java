package io.atruecooky.craftory.content.block;

import com.mojang.serialization.MapCodec;

import io.atruecooky.craftory.content.block_entity.QueryBlockEntity;
import io.atruecooky.craftory.register.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;

public class QueryBlock extends Block implements EntityBlock {
	
	public static final MapCodec<QueryBlock> CODEC = Block.simpleCodec(QueryBlock::new);

	public static final DirectionProperty FACEING = BlockStateProperties.HORIZONTAL_FACING;

	public QueryBlock(BlockBehaviour.Properties properties) {
		super(properties
			.pushReaction(PushReaction.BLOCK)
		);
		this.stateDefinition.any()
			.setValue(FACEING, Direction.NORTH);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACEING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACEING);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new QueryBlockEntity(ModBlockEntityTypes.QUERY.get(), pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level getterLevel, BlockState _blockState, BlockEntityType<T> _blockEntityType) {
		if (!getterLevel.isClientSide()) return (level, pos, blockState, blockEntity) -> QueryBlockEntity.tickServer(level, pos, blockState, (QueryBlockEntity)blockEntity);
		else return (level, pos, blockState, blockEntity) -> QueryBlockEntity.tickClient(level, pos, blockState, (QueryBlockEntity)blockEntity);
	}

}
