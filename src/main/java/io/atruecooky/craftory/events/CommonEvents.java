package io.atruecooky.craftory.events;

import java.util.Map;

import com.ibm.icu.impl.Pair;

import io.atruecooky.craftory.content.items.WrenchItem;
import io.atruecooky.craftory.content.paylods.WrenchPayload;
import io.atruecooky.craftory.core.fume.FumeRegistry;
import io.atruecooky.craftory.register.data.ModBurnable;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber
public class CommonEvents {
	
	@SubscribeEvent
	public static void onEvent(NewRegistryEvent event) {
		event.register(FumeRegistry.FUME_REGISTRY);
	}

	@SubscribeEvent
	public static void onEvent(PlayerEvent.BreakSpeed event) {
		WrenchItem.wrnechBreakSpeed(event);
	}

	@SubscribeEvent 
	public static void onEvent(HarvestCheck event) {
		WrenchItem.wrenchHravestCheck(event);
	}

	@SubscribeEvent 
	public static void onEvent(RegisterPayloadHandlersEvent event) {
		PayloadRegistrar registrar = event.registrar("1");
		WrenchPayload.getPayloadHandlers(registrar);
	}

	@SubscribeEvent 
	public static void onEvent(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {

			ModBurnable.bootstrap();
			
			FireBlock fireBlock = (FireBlock)Blocks.FIRE;
			for (Map.Entry<? extends Block,Pair<Integer,Integer>> entry : ModBurnable.BurnableBlocks.entrySet()) {
				fireBlock.setFlammable(entry.getKey(), entry.getValue().first, entry.getValue().second);
			}
		});
	}

	@SubscribeEvent 
	public static void onEvent(FurnaceFuelBurnTimeEvent event) {
		Item item = event.getItemStack().getItem();
		if (ModBurnable.BurnableItems.containsKey(item)) {
			event.setBurnTime(ModBurnable.BurnableItems.get(item));
		}
	}

}
