package io.atruecooky.craftory.datagen.entries;

import java.util.List;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeature {
	
	public static final ResourceKey<PlacedFeature> TIN_ORE = key("tin_ore");

	public static void bootstrap(BootstrapContext<PlacedFeature> contex) {

		var lookup = contex.lookup(Registries.CONFIGURED_FEATURE);
		PlacementUtils.register(contex, TIN_ORE, lookup.getOrThrow(ModConfiguredFeature.TIN_ORE), List.of(
			HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64)),
			CountPlacement.of(4),
			InSquarePlacement.spread(),
			BiomeFilter.biome()
		));
		
	}

	public static ResourceKey<PlacedFeature> key(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Craftory.namespace(id));
	}

}
