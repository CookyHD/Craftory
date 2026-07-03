package io.atruecooky.locomotion.content.items;

import io.atruecooky.locomotion.content.ModDataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NeedleGunItem extends Item {
	
	public static NeedleGunItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.stacksTo(1);
		properties.component(ModDataComponents.AMMO, null);
		return new NeedleGunItem(properties);
	}

	private NeedleGunItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		
		return super.use(level, player, usedHand);
	}
}
