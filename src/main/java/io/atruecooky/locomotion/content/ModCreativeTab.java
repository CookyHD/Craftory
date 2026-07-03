package io.atruecooky.locomotion.content;

import java.util.function.Supplier;

import io.atruecooky.locomotion.Locomotion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTab {
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Locomotion.MODID);

	public static final Supplier<CreativeModeTab> MAIN = CREATIVE_TAB.register("main", () ->
		CreativeModeTab.builder()
			.icon(() -> new ItemStack(ModItems.ICON.get()))
			.title(Component.translatable("creative_tab.locomotion.main"))
			.displayItems((parameter,output) -> {
				output.accept(ModItems.WRENCH);
				output.accept(ModItems.ENGINE_TERMOSTAT);
				output.accept(ModItems.SLAG);
				output.accept(ModItems.PLASTIC);
				output.accept(ModBlocks.SLAG_BLOCK);
				output.accept(ModBlocks.PLASTIC_BLOCK);
				output.accept(ModBlocks.SLAG_COLLECTOR);
			})
			.build()
	);

	
	public static final Supplier<CreativeModeTab> WEAPONS = CREATIVE_TAB.register("weapons", () ->
		CreativeModeTab.builder()
			.icon(() -> new ItemStack(ModItems.NEEDLE_GUN.get()))
			.title(Component.translatable("creative_tab.locomotion.weapons"))
			.withTabsBefore(ResourceLocation.fromNamespaceAndPath(Locomotion.MODID, "main"))
			.displayItems((parameter,output) -> {
				output.accept(ModItems.NEEDLE_GUN);
				output.accept(ModItems.MAGAZINE);
				output.accept(ModItems.MOLTEN_MAGAZINE);
			})
			.build()
	);

	public static void register(IEventBus eventBus) {
		CREATIVE_TAB.register(eventBus);
	}

}
