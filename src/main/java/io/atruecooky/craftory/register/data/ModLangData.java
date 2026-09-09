package io.atruecooky.craftory.register.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.EntityEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.datagen.DataLangProvider;
import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.register.ModCreativeTabs;
import io.atruecooky.craftory.register.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModLangData {
	
	public static void load() {
		AddLang(ModItems.WRENCH, "Wrench");
		AddLang(ModItems.RAW_TIN, "Raw Tin");

		AddLang(ModBlocks.FRAME, "Construction Frame");
		AddLang(ModBlocks.HEAT_SOURCE, "Creative Heat Source");

		AddLang(ModBlocks.TIN_ORE, "Tin Ore");
		AddLang(ModBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");

		AddLang(ModCreativeTabs.MAIN, "Craftory");
		AddLang(ModCreativeTabs.BLOCKS, "Craftory: Block's");
	}

	public static void AddLang(ItemEntry<? extends Item> item, String string) {
		DataLangProvider.addTranslation(item.get(), string);
	}

	public static void AddLang(BlockEntry<? extends Block> block, String string) {
		DataLangProvider.addTranslation(block.get(), string);
	}

	public static void AddLang(EntityEntry<? extends Entity> entity, String string) {
		DataLangProvider.addTranslation(entity.get(), string);
	}

	public static void AddLang(DeferredHolder<? extends CreativeModeTab,? extends CreativeModeTab> creative_tab, String string) {
		DataLangProvider.addTranslation(creative_tab.get(), string);
	}

	public static void AddLang(String key, String string) {
		DataLangProvider.addTranslation(key, string);
	}
}
