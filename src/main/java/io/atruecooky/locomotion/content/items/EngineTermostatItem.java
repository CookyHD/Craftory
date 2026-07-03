package io.atruecooky.locomotion.content.items;

import net.minecraft.world.item.Item;

public class EngineTermostatItem extends Item {
	
	public static EngineTermostatItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.stacksTo(1);
		return new EngineTermostatItem(properties);
	}

	private EngineTermostatItem(Item.Properties properties) {
		super(properties);
	}

	//TODO: Custom Right Click Logic!

}
