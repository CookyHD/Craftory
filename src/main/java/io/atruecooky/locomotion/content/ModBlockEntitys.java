package io.atruecooky.locomotion.content;

import java.util.function.Supplier;

import io.atruecooky.locomotion.Locomotion;
import io.atruecooky.locomotion.content.block.entity.SlagCollectorEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntitys {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITYS = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Locomotion.MODID);

	public static final Supplier<BlockEntityType<SlagCollectorEntity>> SLAG_COLLECTOR = BLOCK_ENTITYS.register("slag_collector_entity", () ->
		BlockEntityType.Builder.of(SlagCollectorEntity::new, ModBlocks.SLAG_COLLECTOR.get()).build(null)
	);

	public static void register(IEventBus eventBus) {
		BLOCK_ENTITYS.register(eventBus);
	}
}
