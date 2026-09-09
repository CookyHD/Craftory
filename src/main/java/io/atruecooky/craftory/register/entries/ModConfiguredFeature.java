package io.atruecooky.craftory.register.entries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.icu.impl.Pair;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.register.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModConfiguredFeature {

	//register

	public static final Map<ResourceKey<ConfiguredFeature<?, ?>>,Pair<Feature<FeatureConfiguration>,FeatureConfiguration>> ENTRIES = new HashMap<>();

	public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE = create("tin_ore", Feature.ORE, new OreConfiguration(List.of(
			OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TIN_ORE.get().defaultBlockState()),
			OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
		),
		8
	));

	//class

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		
		for (Map.Entry<ResourceKey<ConfiguredFeature<?, ?>>,Pair<Feature<FeatureConfiguration>,FeatureConfiguration>> entry : ENTRIES.entrySet()) {
			FeatureUtils.register(context, entry.getKey(), entry.getValue().first, entry.getValue().second);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends FeatureConfiguration> ResourceKey<ConfiguredFeature<?, ?>> create(String id, Feature<T> feature, T configuration) {
		ResourceKey<ConfiguredFeature<?, ?>> configuredFeature = ResourceKey.create(Registries.CONFIGURED_FEATURE, Craftory.namespace(id));
		ENTRIES.put(configuredFeature, Pair.of((Feature<FeatureConfiguration>)feature, (FeatureConfiguration)configuration));
		return configuredFeature;
	}

	public static void register() {}

}
