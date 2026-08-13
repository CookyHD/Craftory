package io.atruecooky.craftory.register;

import com.mojang.serialization.Codec;
import com.tterrag.registrate.util.entry.RegistryEntry;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;

public class ModDataComponents {

	public static final RegistryEntry<DataComponentType<?>,DataComponentType<Integer>> WRENCH_MODE = Craftory.REGISTRATE.simple("wrench_mode", Registries.DATA_COMPONENT_TYPE, () -> new DataComponentType.Builder<Integer>().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

	public static void register() {}
}
