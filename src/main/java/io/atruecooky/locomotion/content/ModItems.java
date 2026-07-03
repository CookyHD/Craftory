package io.atruecooky.locomotion.content;

import io.atruecooky.locomotion.Locomotion;
import io.atruecooky.locomotion.content.items.DuctItem;
import io.atruecooky.locomotion.content.items.EngineTermostatItem;
import io.atruecooky.locomotion.content.items.NeedleGunItem;
import io.atruecooky.locomotion.content.items.WrenchItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
	
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Locomotion.MODID);

	public static final DeferredItem<Item> ICON = ITEMS.register("icon", () -> new Item(new Item.Properties().stacksTo(1)));

	public static final DeferredItem<WrenchItem> WRENCH = ITEMS.register("wrench", () -> WrenchItem.createWithProperties());
	public static final DeferredItem<EngineTermostatItem> ENGINE_TERMOSTAT = ITEMS.register("engine_termostat", () -> EngineTermostatItem.createWithProperties());
	
	public static final DeferredItem<Item> SLAG = ITEMS.register("slag", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> PLASTIC = ITEMS.register("plastic", () -> new Item(new Item.Properties()));

	public static final DeferredItem<NeedleGunItem> NEEDLE_GUN = ITEMS.register("needle_gun", () -> NeedleGunItem.createWithProperties());

	public static final DeferredItem<Item> MAGAZINE = ITEMS.register("magazine", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> MOLTEN_MAGAZINE = ITEMS.register("molten_magazine", () -> new Item(new Item.Properties()));

	public static final DeferredItem<DuctItem> DUCT = ITEMS.register("duct", () -> DuctItem.createWithProperties());



	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
