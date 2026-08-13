package io.atruecooky.craftory.content.block;

import com.mojang.serialization.MapCodec;

import io.atruecooky.craftory.content.block.entity.HeatSourceEntity;
import io.atruecooky.craftory.register.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class HeatSourceBlock extends TransparentBlock implements EntityBlock {

	public static final MapCodec<HeatSourceBlock> CODEC = BlockBehaviour.simpleCodec(HeatSourceBlock::new);

	public HeatSourceBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new HeatSourceEntity(ModBlockEntityTypes.HEAT_SOURCE.get() ,pos, state);
	};
}
