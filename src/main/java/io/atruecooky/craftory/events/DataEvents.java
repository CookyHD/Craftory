package io.atruecooky.craftory.events;


import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.datagen.DataBlockModelProvider;
import io.atruecooky.craftory.datagen.DataBlockTagsProvider;
import io.atruecooky.craftory.datagen.DataLootTableProvider;
import io.atruecooky.craftory.register.data.ModLangData;
import io.atruecooky.craftory.register.data.ModLootTableData;
import io.atruecooky.craftory.register.data.ModModelData;
import io.atruecooky.craftory.register.data.ModTagData;
import io.atruecooky.craftory.datagen.DataEntriesProvider;
import io.atruecooky.craftory.datagen.DataItemModelProvider;
import io.atruecooky.craftory.datagen.DataItemTagsProvider;
import io.atruecooky.craftory.datagen.DataLangProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber
public class DataEvents {
	
	@SubscribeEvent
	public static void onEvent(GatherDataEvent event) {

		ModTagData.load();
		ModLootTableData.load();
		ModLangData.load();
		ModModelData.load();

		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		generator.addProvider(
			event.includeClient(),
			new DataBlockModelProvider(output, existingFileHelper)
		);

		generator.addProvider(
			event.includeClient(),
			new DataItemModelProvider(output, existingFileHelper)
		);

		DataBlockTagsProvider blockTags = new DataBlockTagsProvider(output, lookupProvider, existingFileHelper);
		DataItemTagsProvider itemTags = new DataItemTagsProvider(output, lookupProvider, blockTags, existingFileHelper);

		generator.addProvider(
			event.includeServer(),
			blockTags
		);

		generator.addProvider(
			event.includeServer(),
			itemTags
		);
	
		generator.addProvider(
			event.includeServer(),
			new DataEntriesProvider(output, lookupProvider)
		);

		generator.addProvider(
			event.includeServer(),
			new DataLootTableProvider(output, lookupProvider)
		);

		generator.addProvider(
			event.includeClient(),
			new DataLangProvider(output)
		);
	}

}

