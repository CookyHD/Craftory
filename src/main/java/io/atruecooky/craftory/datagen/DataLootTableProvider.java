package io.atruecooky.craftory.datagen;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class DataLootTableProvider extends LootTableProvider {
	
	public DataLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, Set.of(), getSubProviders(), lookupProvider);
	}

	private static List<LootTableProvider.SubProviderEntry> getSubProviders() {
		return List.of(
			new LootTableProvider.SubProviderEntry(
				DataBlockLootTableProvider::new,
				LootContextParamSets.BLOCK
			)
		);
	}
}
