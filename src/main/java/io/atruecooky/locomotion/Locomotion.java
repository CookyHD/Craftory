package io.atruecooky.locomotion;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import io.atruecooky.locomotion.content.ModBlockEntitys;
import io.atruecooky.locomotion.content.ModBlocks;
import io.atruecooky.locomotion.content.ModCreativeTab;
import io.atruecooky.locomotion.content.ModDataComponents;
import io.atruecooky.locomotion.content.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Locomotion.MODID)
public class Locomotion {

	public static IEventBus EVENT_BUS;

	public static final String MODID = "locomotion";
	public static final Logger LOGGER = LogUtils.getLogger();

	public Locomotion(IEventBus modEventBus, ModContainer modContainer) {

		Locomotion.EVENT_BUS = modEventBus;

		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModCreativeTab.register(modEventBus);
		ModDataComponents.register(modEventBus);
		ModBlockEntitys.register(modEventBus);
	}
}
