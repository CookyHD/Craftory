package io.atruecooky.craftory.core.fume;

import org.jetbrains.annotations.Nullable;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.BlockCapability;

public class FumeCapability {
	
	private static final BlockCapability<FumeHandler,@Nullable Direction> FUME = BlockCapability.createSided(Craftory.namespace("fume"), FumeHandler.class);

	public static BlockCapability<FumeHandler,@Nullable Direction> get() {
		return FUME;
	}
}
