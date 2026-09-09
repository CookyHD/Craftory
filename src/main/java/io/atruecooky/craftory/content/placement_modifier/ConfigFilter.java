package io.atruecooky.craftory.content.placement_modifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.atruecooky.craftory.CraftoryConfig;
import io.atruecooky.craftory.register.ModPlacementModifier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class ConfigFilter extends PlacementFilter {
	
	public static final MapCodec<ConfigFilter> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.STRING.fieldOf("config").forGetter(ConfigFilter::getConfig)
		).apply(instance, ConfigFilter::new)
	);

	private final String config;

	private ConfigFilter(String config) {
		this.config = config;
	}

	public static ConfigFilter of(String config) {
		return new ConfigFilter(config);
	}

	public String getConfig() {
		return config;
	}

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
		return CraftoryConfig.isWorldgenEnabled(this.config);
	}

	@Override
	public PlacementModifierType<?> type() {
		return ModPlacementModifier.CONFIG_FILTER.get();
	}
}
