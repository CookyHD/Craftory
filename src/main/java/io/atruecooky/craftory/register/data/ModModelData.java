package io.atruecooky.craftory.register.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.datagen.DataBlockModelProvider;
import io.atruecooky.craftory.datagen.DataItemModelProvider;
import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.register.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModModelData {
	
	public static void load() {
		ItemModel(ModItems.WRENCH, Type.HANDHELD);
		ItemModel(ModItems.RAW_TIN, Type.BASIC);

		BlockModel(ModBlocks.TIN_ORE, Type.CUBE_ALL);
		BlockModel(ModBlocks.DEEPSLATE_TIN_ORE, Type.CUBE_ALL);
	}

	public static void BlockModel(BlockEntry<? extends Block> block, Type type) {
		DataBlockModelProvider.addBlockModel(block.get(), type);
	}

	public static void ItemModel(ItemEntry<? extends Item> item, Type type) {
		DataItemModelProvider.addItemModel(item.get(), type);
	}

	public enum Type {
		HANDHELD,
		BASIC,
		CUBE_ALL
	}
}
