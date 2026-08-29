package io.atruecooky.craftory.events;

import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.datagen.BlockModelGenerator;
import io.atruecooky.craftory.datagen.BlockTagsGenerator;
import io.atruecooky.craftory.datagen.EntriesGenerator;
import io.atruecooky.craftory.datagen.ItemModelGenerator;
// import net.minecraft.client.Minecraft;
// import net.minecraft.client.renderer.texture.TextureManager;
// import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
// import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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

		//BLOCK-TAGS
		generator.addProvider(
			event.includeServer(),
			new BlockTagsGenerator(output, lookupProvider, Craftory.MODID, existingFileHelper)
		);

		//ENTRIES
		generator.addProvider(
			event.includeServer(),
			new EntriesGenerator(output, lookupProvider)
		);

		// //FUME-ATLAS
		// generator.addProvider(
		// 	event.includeClient(),
		// 	new SpriteSourceProvider(output, lookupProvider, Craftory.MODID, existingFileHelper) {
		// 		@Override
		// 		protected void gather() {
		// 			this.atlas(Craftory.namespace("fumes")).addSource(new DirectoryLister("fume", ""));
		// 		}
		// 	}
		// );

	}

	// //ATLAS-RELOADER
	// @SubscribeEvent
	// public static void onEvent(RegisterClientReloadListenersEvent event) {
	// 	event.registerReloadListener(FumeAtlas.getIntance());
	// }

	// public static class FumeAtlas extends TextureAtlasHolder {

	// 	public static final ResourceLocation LOCATION = Craftory.namespace("textures/atlas/fumes.png");

	// 	public FumeAtlas(TextureManager textureManager) {
	// 		super(textureManager, LOCATION, Craftory.namespace("fumes"));
	// 	}

	// 	private static FumeAtlas intance;

	// 	public static FumeAtlas getIntance() {
	// 		if (intance == null) intance = new FumeAtlas(Minecraft.getInstance().getTextureManager());
	// 		return intance;
	// 	}
	// }
}

