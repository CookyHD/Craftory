package io.atruecooky.craftory.register.data;

import java.util.function.Function;

import io.atruecooky.craftory.datagen.DataBlockLootTableProvider;
import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.register.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTableData {
	
	public static void load() {

		BlockLootTable(ModBlocks.FRAME.get(), provider -> provider.createSingleItemTable(Items.COPPER_INGOT));

		BlockLootTable(ModBlocks.TIN_ORE.get(), provider -> provider.createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
		BlockLootTable(ModBlocks.DEEPSLATE_TIN_ORE.get(), provider -> provider.createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));

		BlockLootTableSelf(ModBlocks.HEAT_SOURCE.get());

	}

	public static void BlockLootTable(Block block, Function<DataBlockLootTableProvider,? extends LootTable.Builder> func) {
		DataBlockLootTableProvider.addBlockLoot(block, func);
	}

	public static void BlockLootTableSelf(Block block) {
		DataBlockLootTableProvider.addBlockLoot(block, provider -> provider.createSingleItemTable(block));
	}
}
