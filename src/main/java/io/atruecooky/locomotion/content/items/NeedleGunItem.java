package io.atruecooky.locomotion.content.items;

import io.atruecooky.locomotion.content.ModDataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class NeedleGunItem extends Item {
	
	public static NeedleGunItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.stacksTo(1);
		properties.component(ModDataComponents.AMMONITION, ItemStack.EMPTY);
		return new NeedleGunItem(properties);
	}

	private NeedleGunItem(Item.Properties properties) {
		super(properties);
	}
}
