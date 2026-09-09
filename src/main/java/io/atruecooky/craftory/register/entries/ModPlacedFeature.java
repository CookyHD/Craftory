package io.atruecooky.craftory.register.entries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.icu.impl.Pair;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.placement_modifier.ConfigFilter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacedFeature {
	
	//register

	private static final Map<ResourceKey<PlacedFeature>,Pair<ResourceKey<ConfiguredFeature<?, ?>>,List<PlacementModifier>>> ENTRIES = new HashMap<>();

	public static final ResourceKey<PlacedFeature> TIN_ORE = create("tin_ore", ModConfiguredFeature.TIN_ORE, List.of(
		HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64)),
		CountPlacement.of(4),
		InSquarePlacement.spread(),
		BiomeFilter.biome(),
		ConfigFilter.of("tin_ore")
	));

	//class

	public static void bootstrap(BootstrapContext<PlacedFeature> contex) {
		var lookup = contex.lookup(Registries.CONFIGURED_FEATURE);
		for (Map.Entry<ResourceKey<PlacedFeature>,Pair<ResourceKey<ConfiguredFeature<?, ?>>,List<PlacementModifier>>> entry : ENTRIES.entrySet()) {
			PlacementUtils.register(contex, entry.getKey(), lookup.getOrThrow(entry.getValue().first), entry.getValue().second);
		};
	}

	public static ResourceKey<PlacedFeature> create(String id, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers) {
		ResourceKey<PlacedFeature> feature = ResourceKey.create(Registries.PLACED_FEATURE, Craftory.namespace(id));
		ENTRIES.put(feature, Pair.of(configuredFeature, modifiers));
		return feature;
	}

	public static void register() {}

}
