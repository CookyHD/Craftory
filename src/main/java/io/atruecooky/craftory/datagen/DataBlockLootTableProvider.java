package io.atruecooky.craftory.datagen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;

public class DataBlockLootTableProvider extends BlockLootSubProvider {
	
	public DataBlockLootTableProvider(HolderLookup.Provider lookupProvider) {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
	}

	public static final List<Block> BLOCK_LIST = new ArrayList<>();
	public static final Map<Block,Function<DataBlockLootTableProvider,? extends LootTable.Builder>> ENTRIES = new HashMap<>();

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BLOCK_LIST;
	}

	@Override
	protected void generate() {

		for (Map.Entry<Block,Function<DataBlockLootTableProvider,? extends LootTable.Builder>> entry : ENTRIES.entrySet()) {
			add(entry.getKey(),entry.getValue().apply(this));
		}

	}

	@Override
	public  Builder createOreDrop(Block block, Item item) {
		return super.createOreDrop(block, item);
	}

	public static void addBlockLoot(Block block, Function<DataBlockLootTableProvider,? extends LootTable.Builder> func) {
		if (!ENTRIES.containsKey(block)) {
			ENTRIES.put(block, func);
			BLOCK_LIST.add(block);
		}
	}

}
