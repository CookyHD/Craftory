package io.atruecooky.craftory.core.heat;

import org.jetbrains.annotations.Nullable;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.BlockCapability;

public class HeatCapability {
	
	private static final BlockCapability<HeatHandler,@Nullable Direction> HEAT = BlockCapability.createSided(Craftory.namespace("heat"), HeatHandler.class);

	public static BlockCapability<HeatHandler,@Nullable Direction> get() {
		return HEAT;
	}
}
