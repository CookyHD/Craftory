package io.atruecooky.craftory.register.entries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier;

public class ModBiomeModifiers {

	//register

	public static final Map<ResourceKey<BiomeModifier>,Function<BootstrapContext<BiomeModifier>,BiomeModifier>> ENTRIES = new HashMap<>();
	
	public static final ResourceKey<BiomeModifier> TIN_ORE = create("tin_ore", (context) -> {
		return new AddFeaturesBiomeModifier(
			context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD),
			HolderSet.direct(
				context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacedFeature.TIN_ORE)
			),
			Decoration.UNDERGROUND_ORES
		);
	});

	//class

	public static void bootstrap(BootstrapContext<BiomeModifier> context) {

		for (Map.Entry<ResourceKey<BiomeModifier>,Function<BootstrapContext<BiomeModifier>,BiomeModifier>> entry : ENTRIES.entrySet()) {
			context.register(entry.getKey(), entry.getValue().apply(context));
		}
	}

	public static ResourceKey<BiomeModifier> create(String id, Function<BootstrapContext<BiomeModifier>,BiomeModifier> function) {
		ResourceKey<BiomeModifier> biomeModifier = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Craftory.namespace(id));
		ENTRIES.put(biomeModifier, function);
		return biomeModifier;
	}

	public static void register() {}
	
}
