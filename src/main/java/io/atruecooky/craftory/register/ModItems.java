package io.atruecooky.craftory.register;

import io.atruecooky.craftory.content.items.WrenchItem;

import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.items.TermostatItem;
import net.minecraft.world.item.Item;

public class ModItems {
	
	public static final ItemEntry<WrenchItem> WRENCH = Craftory.REGISTRATE.item("wrench", (item) -> WrenchItem.createWithProperties())
	.register();

	public static final ItemEntry<TermostatItem> TERMOSTAT = Craftory.REGISTRATE.item("thermostat", (item) -> TermostatItem.createWithProperties())
	.register();

	public static final ItemEntry<Item> RAW_TIN = Craftory.REGISTRATE.item("raw_tin", Item::new)
	.register();

	public static void register() {}
}
