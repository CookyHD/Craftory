package io.atruecooky.craftory.datagen;

import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.register.ModItems;
import io.atruecooky.craftory.utils.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemTagGenerator extends ItemTagsProvider {
	
	public ItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsGenerator blockTags, String modId, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags.contentsGetter(), modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {

		tag(Tags.Items.RAW_MATERIALS)
		.add(ModItems.RAW_TIN.get())
		;

		tag(TagUtils.itemTagCommon("raw_materials/tin"))
		.add(ModItems.RAW_TIN.get())
		;

		if(ModList.get().isLoaded("vanillabackport")) {

		}
		
	}
}
