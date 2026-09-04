package io.atruecooky.craftory.datagen;

import java.util.List;
import java.util.Set;


import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.register.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class BlockLootTableGenerator extends BlockLootSubProvider {
	
	public BlockLootTableGenerator(HolderLookup.Provider lookupProvider) {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return List.of(
			(Block) ModBlocks.FRAME.get(),
			(Block) ModBlocks.TIN_ORE.get(),
			(Block) ModBlocks.DEEPSLATE_TIN_ORE.get(),
			(Block) ModBlocks.HEAT_SOURCE.get()
		);
	}

	@Override
	protected void generate() {
		add(ModBlocks.FRAME.get(), createSingleItemTable(Items.COPPER_INGOT));
		add(ModBlocks.TIN_ORE.get(), createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
		add(ModBlocks.DEEPSLATE_TIN_ORE.get(), createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));

		dropSelf(ModBlocks.HEAT_SOURCE.get());
	}

}
