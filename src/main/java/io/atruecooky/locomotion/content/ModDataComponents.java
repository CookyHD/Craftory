package io.atruecooky.locomotion.content;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import io.atruecooky.locomotion.Locomotion;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDataComponents {
	
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Locomotion.MODID);

	public static final Supplier<DataComponentType<Integer>> WRENCH_MODE = registerDataComponent("wrench_mode", builder -> builder.persistent(ExtraCodecs.POSITIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT));
	public static final Supplier<DataComponentType<BlockPos>> PLACED_AT = registerDataComponent("place_at", builder -> builder.persistent(BlockPos.CODEC).networkSynchronized(BlockPos.STREAM_CODEC));
	public static final Supplier<DataComponentType<ItemStack>> AMMO = registerDataComponent("ammo", builder -> builder.persistent(ItemStack.CODEC).networkSynchronized(ItemStack.STREAM_CODEC));

	private static final <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> registerDataComponent(String name,UnaryOperator<DataComponentType.Builder<T>> builder) {
		return DATA_COMPONENTS.register(name, () -> builder.apply(DataComponentType.builder()).build());
	};

	public static void register(IEventBus eventBus) {
		DATA_COMPONENTS.register(eventBus);
	}

}
