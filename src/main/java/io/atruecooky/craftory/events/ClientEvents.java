package io.atruecooky.craftory.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber
public class ClientEvents {
	
	@SubscribeEvent
	public static void onEvent(RenderLevelStageEvent event) {
		
	}
}
