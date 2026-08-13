package io.atruecooky.craftory.content.screen;

import io.atruecooky.craftory.content.menu.WrenchMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class WrenchScreen extends AbstractContainerScreen<WrenchMenu> {

	public WrenchScreen(WrenchMenu menu, Inventory inventory, Component title) {
		super(menu, inventory, title);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		//NOTHING LMAO
	}

}
