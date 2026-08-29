package io.atruecooky.craftory.core.fume;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class FumeRegistry {

	public static final ResourceKey<Registry<Fume>> FUME_REGISTRY_KEY = ResourceKey.createRegistryKey(Craftory.namespace("fumes"));
	public static final Registry<Fume> FUME_REGISTRY = new RegistryBuilder<>(FUME_REGISTRY_KEY).create();

}
