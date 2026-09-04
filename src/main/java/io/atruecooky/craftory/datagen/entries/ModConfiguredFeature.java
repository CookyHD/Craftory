package io.atruecooky.craftory.datagen.entries;

import java.util.List;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.register.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModConfiguredFeature {
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE = key("tin_ore");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		
		RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		List<TargetBlockState> tin_ore = List.of(
			OreConfiguration.target(stone, ModBlocks.TIN_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslate, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
		);

		FeatureUtils.register(context, TIN_ORE, Feature.ORE, new OreConfiguration(tin_ore, 8));

	}

	public static ResourceKey<ConfiguredFeature<?, ?>> key(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Craftory.namespace(id));
	}

}
