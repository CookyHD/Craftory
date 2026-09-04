package io.atruecooky.craftory.events;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.datagen.BlockLootTableGenerator;
import io.atruecooky.craftory.datagen.BlockModelGenerator;
import io.atruecooky.craftory.datagen.BlockTagsGenerator;
import io.atruecooky.craftory.datagen.EntriesGenerator;
import io.atruecooky.craftory.datagen.ItemModelGenerator;
import io.atruecooky.craftory.datagen.ItemTagGenerator;
// import io.atruecooky.craftory.datagen.ItemModelGenerator;
// import net.minecraft.client.Minecraft;
// import net.minecraft.client.renderer.texture.TextureManager;
// import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
// import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
// import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
// import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
// import net.neoforged.neoforge.common.data.SpriteSourceProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber
public class DataEvents {
	
	@SubscribeEvent
	public static void onEvent(GatherDataEvent event) {

		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		//BLOCK-MODELS
		generator.addProvider(
			event.includeClient(),
			new BlockModelGenerator(output, Craftory.MODID, existingFileHelper)
		);

		//ITEM-MODELS
		generator.addProvider(
			event.includeClient(),
			new ItemModelGenerator(output, Craftory.MODID, existingFileHelper)
		);

		//TAGS

		BlockTagsGenerator blockTags = new BlockTagsGenerator(output, lookupProvider, Craftory.MODID, existingFileHelper);
		ItemTagGenerator itemTags = new ItemTagGenerator(output, lookupProvider, blockTags, Craftory.MODID, existingFileHelper);

		generator.addProvider(
			event.includeServer(),
			blockTags
		);

		generator.addProvider(
			event.includeServer(),
			itemTags
		);
	

		//ENTRIES
		generator.addProvider(
			event.includeServer(),
			new EntriesGenerator(output, lookupProvider)
		);

		//LOOT-TABLES
		generator.addProvider(
			event.includeServer(),
			new LootTableProvider(
				output,
				Set.of(),
				List.of(
					new LootTableProvider.SubProviderEntry(
						BlockLootTableGenerator::new,
						LootContextParamSets.BLOCK
					)
				),
				lookupProvider
			)
		);
	}

}

