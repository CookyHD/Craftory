package io.atruecooky.craftory.register;

import io.atruecooky.craftory.content.items.WrenchItem;
import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.Craftory;

public class ModItems {
	
	public static final ItemEntry<WrenchItem> WRENCH = Craftory.registrate().item("wrench", (item) -> WrenchItem.createWithProperties())
	.register();

	public static final ItemEntry<Item> RAW_TIN = Craftory.registrate().item("raw_tin", Item::new)
	.register();

	public static void register() {}
}
