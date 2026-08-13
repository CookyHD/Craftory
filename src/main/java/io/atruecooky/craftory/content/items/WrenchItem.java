package io.atruecooky.craftory.content.items;

import io.atruecooky.craftory.register.ModDataComponents;
import net.minecraft.world.item.Item;

public class WrenchItem extends Item {


	public static WrenchItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.component(ModDataComponents.WRENCH_MODE, 0);
		properties.stacksTo(1);
		return new WrenchItem(properties);
	}

	private WrenchItem(Item.Properties properties) {
		super(properties);
	};


}

