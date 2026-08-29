package io.atruecooky.craftory.datagen.entries;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier;

public class ModBiomeModifiers {
	
	public static final ResourceKey<BiomeModifier> TIN_ORE = key("tin_ore");

	public static void bootstrap(BootstrapContext<BiomeModifier> context) {
		var biomeLookup = context.lookup(Registries.BIOME);
		HolderSet<Biome> overworld = biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD);

		var featureLookup = context.lookup(Registries.PLACED_FEATURE);
		Holder<PlacedFeature> tinOre = featureLookup.getOrThrow(ModPlacedFeature.TIN_ORE);

		context.register(TIN_ORE, addOre(overworld, tinOre));

	}

	public static ResourceKey<BiomeModifier> key(String id) {
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Craftory.namespace(id));
	}

	public static AddFeaturesBiomeModifier addOre(HolderSet<Biome> biomes, Holder<PlacedFeature> placedFeature) {
		return new AddFeaturesBiomeModifier(biomes, HolderSet.direct(placedFeature), Decoration.UNDERGROUND_ORES);
	}
}
