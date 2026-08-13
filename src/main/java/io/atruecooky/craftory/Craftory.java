package io.atruecooky.craftory;

import com.tterrag.registrate.Registrate;

import io.atruecooky.craftory.register.ModBlockEntityTypes;
import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.register.ModCreativeTabs;
import io.atruecooky.craftory.register.ModDataComponents;
import io.atruecooky.craftory.register.ModFumes;
import io.atruecooky.craftory.register.ModItems;
import io.atruecooky.craftory.register.ModMenuTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Craftory.MODID)
public class Craftory {

	public static final String MODID = "craftory";
	public static final Registrate REGISTRATE = Registrate.create(MODID).defaultCreativeTab((ResourceKey<CreativeModeTab>)null);

	public Craftory(IEventBus eventBus, ModContainer modContainer) {

		REGISTRATE.setModEventBus(eventBus);

		ModItems.register();
		ModBlocks.register();
		ModBlockEntityTypes.register();
		ModFumes.register();
		ModCreativeTabs.register(eventBus);
		ModMenuTypes.register();
		ModDataComponents.register();

	}

	public static ResourceLocation namespace(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}
}
