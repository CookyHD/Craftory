package io.atruecooky.craftory.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.datagen.entries.ModBiomeModifiers;
import io.atruecooky.craftory.datagen.entries.ModConfiguredFeature;
import io.atruecooky.craftory.datagen.entries.ModPlacedFeature;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class EntriesGenerator extends DatapackBuiltinEntriesProvider {

	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
		.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeature::bootstrap)
		.add(Registries.PLACED_FEATURE, ModPlacedFeature::bootstrap)
		.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
	;

	public EntriesGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> regstries) {
		super(output, regstries, BUILDER, Set.of(Craftory.MODID));
	}
	 
}
