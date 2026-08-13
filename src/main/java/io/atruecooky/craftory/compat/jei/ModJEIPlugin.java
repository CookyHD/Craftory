package io.atruecooky.craftory.compat.jei;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.compat.jei.handlers.NoScreenHandler;
import io.atruecooky.craftory.content.screen.WrenchScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {


	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
		registration.addGuiScreenHandler(WrenchScreen.class, (screen) -> new NoScreenHandler<>());
	}

	@Override
	public ResourceLocation getPluginUid() {
		return Craftory.namespace("plugin");
	}

	
}
