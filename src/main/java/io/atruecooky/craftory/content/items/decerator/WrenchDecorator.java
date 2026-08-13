package io.atruecooky.craftory.content.items.decerator;

//import com.mojang.blaze3d.systems.RenderSystem;

import io.atruecooky.craftory.register.ModDataComponents;
import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.IItemDecorator;

public class WrenchDecorator implements IItemDecorator {
	
	@Override
	public boolean render(GuiGraphics guiGraphics, Font font, ItemStack stack, int xOffset, int yOffset) {
		//RenderSystem.enableBlend();
		fill(guiGraphics, xOffset+1, yOffset+1, color(stack).darken(0.8f).alpha(155));
		fill(guiGraphics, xOffset, yOffset, color(stack));
		//RenderSystem.disableBlend();
		return true;
	}

	private void fill(GuiGraphics guiGraphics,int x, int y, Color color) {
		guiGraphics.fill(x+1, y+1, x+3, y+3, color.asPacked());
	}

	private Color color(ItemStack stack) {
		switch (stack.get(ModDataComponents.WRENCH_MODE)) {
			case 1:
				return Color.AQUA;
			default:
				return Color.WHITE;

		}
	}
}
