package io.atruecooky.craftory.datagen;

import java.util.concurrent.CompletableFuture;

import com.tterrag.registrate.util.entry.BlockEntry;

import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.utils.Tag;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockTagsGenerator extends BlockTagsProvider {
	
	public BlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.stoneOre(ModBlocks.TIN_ORE, "tin");
		this.stoneOre(ModBlocks.DEEPSLATE_TIN_ORE, "tin", true);
	}

	public <T extends Block> void stoneOre(BlockEntry<T> entry, String ore_type) {
		stoneOre(entry, ore_type, false);
	}

	public <T extends Block> void stoneOre(BlockEntry<T> entry, String ore_type, boolean isDeep) {
		T block = entry.get();
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
		this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).add(block);
		this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).add(block);
		this.tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(block);
		this.tag(BlockTags.SNAPS_GOAT_HORN).add(block);
		this.tag(Tags.Blocks.ORES).add(block);
		this.tag(Tags.Blocks.ORE_RATES_SINGULAR).add(block);
		this.tag(Tag.blockTagCommon("ores/"+ore_type)).add(block);
		if (isDeep) this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(block);
		else this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(block);
	}
	
}
