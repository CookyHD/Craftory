package io.atruecooky.craftory;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import io.atruecooky.craftory.register.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Craftory.MODID)
public class Craftory {

	
	public static final String MODID = "craftory";
	public static final Logger LOG = LogUtils.getLogger();

	public static final CraftoryRegistrate REGISTRATE = CraftoryRegistrate.create(MODID);

	public Craftory(IEventBus eventBus, ModContainer modContainer) {

		REGISTRATE.setModEventBus(eventBus);

		ModItems.register();
		ModBlocks.register();
		ModBlockEntityTypes.register();
		ModFumes.register();
		ModFluids.register();
		ModCreativeTabs.register(eventBus);
		ModMenuTypes.register();
		ModDataComponents.register();

	}

	public static CraftoryRegistrate registrate() {
		return REGISTRATE;
	}

	public static ResourceLocation namespace(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}
}
