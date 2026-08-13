package io.atruecooky.craftory.compat.jei.handlers;

import mezz.jei.api.gui.handlers.IGuiProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class NoScreenHandler <T extends Screen> implements IGuiProperties {

	private Class<T> screen; 

	public NoScreenHandler() {}

	public Class<T> screenClass() {
		return screen;
	}

	public int guiLeft() {
		return 0;
	}

	public int guiTop() {
		return 0;
	}

	public int guiXSize() {
		return this.screenWidth();
	}

	public int guiYSize() {
		return this.screenHeight();
	}

	public int screenWidth() {
		return Minecraft.getInstance().getWindow().getWidth();
	}

	public int screenHeight() {
		return Minecraft.getInstance().getWindow().getHeight();
	}
}
