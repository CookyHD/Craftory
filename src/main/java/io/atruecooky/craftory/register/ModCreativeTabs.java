package io.atruecooky.craftory.register;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.core.menu.IconCreativeModeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Craftory.MODID);

	public static final DeferredHolder<CreativeModeTab, IconCreativeModeTab> MAIN = CREATIVE_MODE_TAB.register("main", () -> new IconCreativeModeTab(
		CreativeModeTab.builder()
		.title(Component.translatable("creative_tab.craftory.main"))
		.withTabsAfter(Craftory.namespace("blocks"))
		.displayItems((parameter, output) -> {
			output.accept(ModBlocks.HEAT_SOURCE);
			output.accept(ModItems.WRENCH);
			output.accept(ModItems.RAW_TIN);
		}),
		Craftory.namespace("textures/gui/icon/main.png")
	));
	
	public static final DeferredHolder<CreativeModeTab, IconCreativeModeTab> BLOCKS = CREATIVE_MODE_TAB.register("blocks", () -> new IconCreativeModeTab(
		CreativeModeTab.builder()
		.title(Component.translatable("creative_tab.craftory.blocks"))
		.withTabsBefore(Craftory.namespace("main"))
		.displayItems((parameter, output) -> {
			output.accept(ModBlocks.TIN_ORE.get());
			output.accept(ModBlocks.DEEPSLATE_TIN_ORE.get());
		}),
		Craftory.namespace("textures/gui/icon/blocks.png")
	));
	
	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TAB.register(eventBus);
	}
}
