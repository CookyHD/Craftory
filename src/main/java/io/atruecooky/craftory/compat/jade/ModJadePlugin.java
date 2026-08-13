package io.atruecooky.craftory.compat.jade;

import io.atruecooky.craftory.compat.jade.provider.*;
import net.minecraft.world.level.block.Block;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class ModJadePlugin implements IWailaPlugin {
	
	@Override
	public void register(IWailaCommonRegistration registration) {
		registration.registerBlockDataProvider(new HeatStorageProvider(), Block.class);
		registration.registerBlockDataProvider(new FumeStorageProvider(), Block.class);
		registration.registerBlockDataProvider(new FluxStorageProvider(), Block.class);
	}
	
	@Override
	public void registerClient(IWailaClientRegistration registration) {
		registration.registerBlockComponent(new HeatStorageProvider(), Block.class);
		registration.registerBlockComponent(new FumeStorageProvider(), Block.class);
		registration.registerBlockComponent(new FluxStorageProvider(), Block.class);
	}
}
