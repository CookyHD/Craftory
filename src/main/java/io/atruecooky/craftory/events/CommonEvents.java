package io.atruecooky.craftory.events;

import io.atruecooky.craftory.core.fume.FumeRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber
public class CommonEvents {
	
	@SubscribeEvent
	public static void onEvent(NewRegistryEvent event) {
		event.register(FumeRegistry.FUME_REGISTRY);
	}

}
