package io.atruecooky.craftory.datagen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataBlockTagsProvider extends BlockTagsProvider {

	public static final Map<TagKey<Block>,List<Block>> ENTRIES = new HashMap<>();
	
	public DataBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Craftory.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		for (Map.Entry<TagKey<Block>,List<Block>> entry : ENTRIES.entrySet()) {
			for (Block item : entry.getValue()) {
				tag(entry.getKey()).add(item);
			}
		}
	}

	public static void tagBlock(TagKey<Block> tag,Block item) {
		if (!ENTRIES.containsKey(tag)) ENTRIES.put(tag, new ArrayList<>());
		if (!ENTRIES.get(tag).contains(item)) ENTRIES.get(tag).add(item);
	}

}
