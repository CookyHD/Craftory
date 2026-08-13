package io.atruecooky.craftory.content.items;

import net.minecraft.world.item.Item;

public class TermostatItem extends Item {
	
	private TermostatItem(Item.Properties properties) {
		super(properties);
	};

	public static TermostatItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.stacksTo(1);
		return new TermostatItem(properties);
	}
}
