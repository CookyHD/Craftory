package io.atruecooky.craftory.datagen;

import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.utils.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockTagsGenerator extends BlockTagsProvider {
	
	public BlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {

		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(ModBlocks.FRAME.get())
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(BlockTags.NEEDS_STONE_TOOL)
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(Tags.Blocks.ORES)
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(Tags.Blocks.ORE_RATES_SINGULAR)
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(TagUtils.blockTagCommon("ores/tin_ore"))
		.add(ModBlocks.TIN_ORE.get())
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
		.add(ModBlocks.DEEPSLATE_TIN_ORE.get())
		;

		this.tag(Tags.Blocks.ORES_IN_GROUND_STONE)
		.add(ModBlocks.TIN_ORE.get())
		;
	}
	
}
