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
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemTagsProvider extends ItemTagsProvider {
	
	public static final Map<TagKey<Item>,List<Item>> ENTRIES = new HashMap<>();

	public DataItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, DataBlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags.contentsGetter(), Craftory.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		for (Map.Entry<TagKey<Item>,List<Item>> entry: ENTRIES.entrySet()) {
			for (Item item : entry.getValue()) tag(entry.getKey()).add(item);
		}
	}

	public static void tagItem(TagKey<Item> tag,Item item) {
		if (!ENTRIES.containsKey(tag)) ENTRIES.put(tag, new ArrayList<>());
		if (!ENTRIES.get(tag).contains(item)) ENTRIES.get(tag).add(item);
	}
	
}
