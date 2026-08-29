package io.atruecooky.craftory.events;

import io.atruecooky.craftory.content.items.decerator.WrenchDecorator;
import io.atruecooky.craftory.content.paylods.WrenchPayload;
import io.atruecooky.craftory.core.fume.FumeRegistry;
import io.atruecooky.craftory.register.ModItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber
public class CommonEvents {
	
	@SubscribeEvent
	public static void onEvent(NewRegistryEvent event) {
		event.register(FumeRegistry.FUME_REGISTRY);
	}

	@SubscribeEvent
	public static void onEvent(RegisterPayloadHandlersEvent event) {
		WrenchPayload.playloadHandlers(event.registrar("1"));
	}

	@SubscribeEvent
	public static void onEvent(RegisterItemDecorationsEvent event) {
		event.register(ModItems.WRENCH, new WrenchDecorator());
	}

}
