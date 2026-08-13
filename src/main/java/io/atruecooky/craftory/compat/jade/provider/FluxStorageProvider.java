package io.atruecooky.craftory.compat.jade.provider;

import io.atruecooky.craftory.Craftory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public class FluxStorageProvider implements IBlockComponentProvider,IServerDataProvider<BlockAccessor> {

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig _pluginConfig) {

	}

	@Override
	public void appendServerData(CompoundTag data, BlockAccessor accessor) {

	}

	@Override
	public ResourceLocation getUid() {
		return Craftory.namespace("flux_storage_provider");
	}

}
