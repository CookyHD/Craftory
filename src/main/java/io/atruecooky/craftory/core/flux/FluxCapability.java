package io.atruecooky.craftory.core.flux;

import org.jetbrains.annotations.Nullable;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.BlockCapability;

public class FluxCapability {
	
	private static final BlockCapability<FluxHandler,@Nullable Direction> FLUX = BlockCapability.createSided(Craftory.namespace("flux"), FluxHandler.class);

	public static BlockCapability<FluxHandler,@Nullable Direction> get() {
		return FLUX;
	}
}
