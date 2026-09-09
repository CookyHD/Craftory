package io.atruecooky.craftory.compat.jade.handler;


import java.util.List;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.register.ModItems;
import io.atruecooky.craftory.register.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import snownee.jade.addon.harvest.ToolHandler;

public class WrenchToolHandler implements ToolHandler {
	
	@Override
	public ItemStack test(BlockState state, Level level, BlockPos pos) {
		if (state.is(ModTags.Blocks.MINEABLE_WRENCH)) return getTools().getFirst();
		else return ItemStack.EMPTY;
	}
	
	@Override
	public List<ItemStack> getTools() {
		return List.of(new ItemStack(ModItems.WRENCH.get()));
	}

	@Override
	public ResourceLocation getUid() {
		return Craftory.namespace("wrench");
	}

}
