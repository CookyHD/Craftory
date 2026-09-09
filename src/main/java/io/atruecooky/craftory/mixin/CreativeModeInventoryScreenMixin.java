package io.atruecooky.craftory.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.atruecooky.craftory.core.menu.CreativeModeIconTab;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;

@Mixin(CreativeModeInventoryScreen.class)
public class CreativeModeInventoryScreenMixin {

	@Inject(method = "renderTabButton", at = @At("HEAD"), cancellable = true)
	public void craftory$renderTabButton(GuiGraphics guiGraphics, CreativeModeTab creativeModeTab, CallbackInfo ci) {
		if (creativeModeTab instanceof CreativeModeIconTab tab) {

			int leftPos = ((ContainerScreenAccessor) this).craftory$getLeftPos();
			int topPos = ((ContainerScreenAccessor) this).craftory$getTopPos();

			int x = (leftPos + craftory$getTabX(tab) + 5);
			int y = (topPos + craftory$getTabY(tab) + 13);

			((GuiGraphicsInvoker) guiGraphics).craftory$innerBlit(
				tab.getIcon(),
				x,
				x+16,
				y,
				y+16,
				1,
				0,
				1,
				0,
				1
			);

			return;
		}
	}

	@Shadow(prefix = "craftory$")
	public int craftory$getTabX(CreativeModeTab tab) {
		return 0;
	};

	@Shadow(prefix = "craftory$")
	public int craftory$getTabY(CreativeModeTab tab) {
		return 0;
	};

}
