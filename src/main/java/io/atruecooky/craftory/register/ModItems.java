package io.atruecooky.craftory.register;

import io.atruecooky.craftory.content.items.WrenchItem;

import com.tterrag.registrate.util.entry.ItemEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.items.TermostatItem;
import net.minecraft.world.item.Item;

public class ModItems {

	public static final ItemEntry<Item> ICON = Craftory.REGISTRATE.item("icon", Item::new)
	.properties((properties) -> properties.stacksTo(1))
	.register();
	
	public static final ItemEntry<WrenchItem> WRENCH = Craftory.REGISTRATE.item("wrench", (item) -> WrenchItem.createWithProperties())
	.register();

	public static final ItemEntry<TermostatItem> TERMOSTAT = Craftory.REGISTRATE.item("thermostat", (item) -> TermostatItem.createWithProperties())
	.register();

	public static void register() {}
}
