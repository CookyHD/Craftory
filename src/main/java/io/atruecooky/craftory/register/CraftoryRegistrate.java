package io.atruecooky.craftory.register;

import com.tterrag.registrate.AbstractRegistrate;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class CraftoryRegistrate extends AbstractRegistrate<CraftoryRegistrate> {
	
	protected CraftoryRegistrate(String modid) {
		super(modid);
	}

	public static CraftoryRegistrate create(String modid) {
		return new CraftoryRegistrate(modid).defaultCreativeTab((ResourceKey<CreativeModeTab>)null);
	}

	@Override
	public void setModEventBus(IEventBus modEventBus) {
		this.registerEventListeners(modEventBus);
		super.setModEventBus(modEventBus);
	}

	@Override
	protected void onData(GatherDataEvent event) {}
}
