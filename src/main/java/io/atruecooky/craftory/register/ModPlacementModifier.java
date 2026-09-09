package io.atruecooky.craftory.register;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.placement_modifier.ConfigFilter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPlacementModifier {
	
	public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPE = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, Craftory.MODID);

	public static final DeferredHolder<PlacementModifierType<?>,PlacementModifierType<ConfigFilter>> CONFIG_FILTER = PLACEMENT_MODIFIER_TYPE.register("config_filter", () -> () -> ConfigFilter.CODEC);

	public static void register(IEventBus eventBus) {
		PLACEMENT_MODIFIER_TYPE.register(eventBus);
	}
}
