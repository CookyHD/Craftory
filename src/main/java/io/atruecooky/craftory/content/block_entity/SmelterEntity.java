package io.atruecooky.craftory.content.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SmelterEntity extends BlockEntity {

	public SmelterEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
	}

	public static void tickServer(ServerLevel level, BlockPos pos, BlockState blockState, SmelterEntity blockEntity) {
		level.sendBlockUpdated(pos, blockState, blockState, 2);
	}

	public static void tickClient(Level level, BlockPos pos, BlockState blockState, SmelterEntity blockEntity) {
	
	}
	
}
