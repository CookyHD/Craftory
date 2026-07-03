package io.atruecooky.locomotion.content.items;

import io.atruecooky.locomotion.Locomotion;
import io.atruecooky.locomotion.content.ModDataComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = Locomotion.MODID)
public class DuctItem extends Item {
	
	public static DuctItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.component(ModDataComponents.PLACED_AT, null);
		properties.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, false);
		return new DuctItem(properties);
	}

	private DuctItem(Item.Properties properties) {
		super(properties);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		
	}
	
}
