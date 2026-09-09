package io.atruecooky.craftory.events;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.items.WrenchItem;
import io.atruecooky.craftory.content.paylods.WrenchPayload;
import io.atruecooky.craftory.core.fume.FumeRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.HarvestCheck;
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
		PayloadRegistrar registrar = event.registrar(Craftory.Version.get());
		WrenchPayload.getPayloadHandlers(registrar);
	}

}
