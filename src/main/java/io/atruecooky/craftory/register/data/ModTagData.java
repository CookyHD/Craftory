package io.atruecooky.craftory.register.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.datagen.DataBlockTagsProvider;
import io.atruecooky.craftory.datagen.DataItemTagsProvider;
import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.register.ModItems;
import io.atruecooky.craftory.register.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

public class ModTagData {
	
	public static void load() {

		//ITEMS

		TagItem(Tags.Items.RAW_MATERIALS,
			ModItems.RAW_TIN
		);
		TagItem(ModTags.Items.RAW_MATERIALS_TIN,
			ModItems.RAW_TIN
		);
	
		TagItem(Tags.Items.TOOLS_WRENCH,
			ModItems.WRENCH
		);

		//BLOCKS

		TagBlock(BlockTags.MINEABLE_WITH_PICKAXE,
			ModBlocks.FRAME,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(BlockTags.NEEDS_STONE_TOOL,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(BlockTags.INCORRECT_FOR_WOODEN_TOOL,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(BlockTags.INCORRECT_FOR_GOLD_TOOL,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(BlockTags.OVERWORLD_CARVER_REPLACEABLES,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(Tags.Blocks.ORES,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(Tags.Blocks.ORE_RATES_SINGULAR,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(ModTags.Blocks.TIN_ORE,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);

		TagBlock(Tags.Blocks.ORES_IN_GROUND_STONE,
			ModBlocks.TIN_ORE
		);

		TagBlock(ModTags.Blocks.MINEABLE_WRENCH,
			ModBlocks.FRAME,
			ModBlocks.HEAT_SOURCE
		);

		//BLOCK-ITEMS

		TagBlockItem(Tags.Items.ORES,
			ModBlocks.TIN_ORE,
			ModBlocks.DEEPSLATE_TIN_ORE
		);
	}

	public static void TagItem(TagKey<Item> tag, ItemEntry<? extends Item> item) {
		DataItemTagsProvider.tagItem(tag, (Item)item.get());
	}

	@SafeVarargs
	public static void TagItem(TagKey<Item> tag, ItemEntry<? extends Item>... items) {
		for (ItemEntry<? extends Item> item : items) {
			TagItem(tag, item);
		}
	}

	@SafeVarargs 
	public static void TagItem(ItemEntry<? extends Item> item, TagKey<Item>... tags) {
		for (TagKey<Item> tag : tags) {
			TagItem(tag, item);
		}
	}

	public static void TagBlock(TagKey<Block> tag, BlockEntry<? extends Block> block) {
		DataBlockTagsProvider.tagBlock(tag, (Block)block.get());
	}

	@SafeVarargs
	public static void TagBlock(TagKey<Block> tag, BlockEntry<? extends Block>... blocks) {
		for (BlockEntry<? extends Block> block : blocks) {
			TagBlock(tag, block);
		}
	}

	@SafeVarargs
	public static void TagBlock(BlockEntry<? extends Block> block, TagKey<Block>... tags) {
		for (TagKey<Block> tag : tags) {
			TagBlock(tag, block);
		}
	}

	public static void TagBlockItem(TagKey<Item> tag, BlockEntry<? extends Block> block) {
		DataItemTagsProvider.tagItem(tag, block.asItem());
	}

	@SafeVarargs
	public static void TagBlockItem(TagKey<Item> tag, BlockEntry<? extends Block>... blocks) {
		for (BlockEntry<? extends Block> block : blocks) {
			TagBlockItem(tag, block);
		}
	}

	@SafeVarargs
	public static void TagBlockItem(BlockEntry<? extends Block> block, TagKey<Item>... tags) {
		for (TagKey<Item> tag : tags) {
			TagBlockItem(tag, block);
		}
	}

	public static class TagUtils {
	
		static public TagKey<Block> blockTagCommon(String name) {
			return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
		}

		static public TagKey<Item> itemTagCommon(String name) {
			return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
		}

		static public TagKey<Block> blockTag(String name) {
			return BlockTags.create(Craftory.namespace(name));
		}

		static public TagKey<Item> itemTag(String name) {
			return ItemTags.create(Craftory.namespace(name));
		}
	}
}
