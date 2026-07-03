package io.atruecooky.locomotion.content.block.entity;

import io.atruecooky.locomotion.content.ModBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DuctEntity extends BlockEntity {
	
	private boolean isReciver = false;

	private BlockPos TargetPos;
	private Direction TargetDirection;

	public DuctEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntitys.DUCT.get(), pos, state);
	}
}
