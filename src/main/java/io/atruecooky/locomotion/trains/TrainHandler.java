package io.atruecooky.locomotion.trains;

import com.simibubi.create.AllEntityTypes;
import com.simibubi.create.content.trains.entity.CarriageContraptionEntity;

import io.atruecooky.locomotion.Locomotion;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = Locomotion.MODID)
public class TrainHandler {

	@SubscribeEvent
	public static void onEntitySpawn(EntityJoinLevelEvent event) {
		if (event.getEntity().getType() != AllEntityTypes.CARRIAGE_CONTRAPTION.get()) return;
		CarriageContraptionEntity carriage = (CarriageContraptionEntity) event.getEntity();

	}

	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Post event) {
		if (event.getEntity().getType() != AllEntityTypes.CARRIAGE_CONTRAPTION.get()) return;
		CarriageContraptionEntity carriage = (CarriageContraptionEntity) event.getEntity();
		
	}
}
