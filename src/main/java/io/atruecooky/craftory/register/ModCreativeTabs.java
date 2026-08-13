package io.atruecooky.craftory.register;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Craftory.MODID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = CREATIVE_MODE_TAB.register("main", () -> CreativeModeTab.builder()
		.icon(() -> new ItemStack(ModItems.ICON.get()))
		.title(Component.translatable("creative_tab.craftory.main"))
		.displayItems((parameter, output) -> {
			output.accept(ModItems.WRENCH.get());
			output.accept(ModItems.TERMOSTAT.get());
			output.accept(ModBlocks.HEAT_SOURCE.get());
		})
		.build()
	);
	
	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TAB.register(eventBus);
	}
}
