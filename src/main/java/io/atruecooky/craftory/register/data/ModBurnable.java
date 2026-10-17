package io.atruecooky.craftory.register.data;

import java.util.HashMap;
import java.util.Map;

import com.ibm.icu.impl.Pair;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.register.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBurnable {
	
	public static final Map<Block,Pair<Integer,Integer>> BurnableBlocks = new HashMap<>();
	public static final Map<Item,Integer> BurnableItems = new HashMap<>();

	public static void bootstrap() {
		addBlockBurnable(ModBlocks.HEAT_SOURCE, 5, 20);
		addItemBurnable(ModBlocks.HEAT_SOURCE.asItem(), 300);
	}

	@SuppressWarnings("unused")
	private static <T extends Block> void addBlockBurnable(BlockEntry<T> blockEntry, int ignite, int burn) {
		BurnableBlocks.put(blockEntry.get(), Pair.of(ignite, burn));
	}

	@SuppressWarnings("unused")
	private static <T extends Block> void addBlockBurnable(T block, int ignite, int burn) {
		BurnableBlocks.put(block, Pair.of(ignite, burn));
	}
	
	@SuppressWarnings("unused")
	private static <T extends Item> void addItemBurnable(ItemEntry<T> itemEntry, int burnTime) {
		BurnableItems.put(itemEntry.get(), burnTime);
	}
	
	@SuppressWarnings("unused")
	private static <T extends Item> void addItemBurnable(T item, int burnTime) {
		BurnableItems.put(item, burnTime);
	}

}
