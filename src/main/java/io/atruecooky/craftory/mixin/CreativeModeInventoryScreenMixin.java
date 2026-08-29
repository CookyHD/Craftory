package io.atruecooky.craftory.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.atruecooky.craftory.core.menu.IconCreativeModeTab;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;

@Mixin(CreativeModeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin {

	@Inject(method = "renderTabButton", at = @At("HEAD"), cancellable = true)
	public void craftory$renderTabButton(GuiGraphics guiGraphics, CreativeModeTab creativeModeTab, CallbackInfo ci) {
		if (creativeModeTab instanceof IconCreativeModeTab tabWithIcon) {

			int leftPos = ((AbstractContainerScreenAccessor) this).craftory$getLeftPos();
			int topPos = ((AbstractContainerScreenAccessor) this).craftory$getTopPos();

			int x = (leftPos + this.craftory$getTabX(tabWithIcon) + 5) * 2;
			int y = (topPos + this.craftory$getTabY(tabWithIcon) + 13) * 2;

			int size = tabWithIcon.getIconSize();
			float scale = 16f / size;

			guiGraphics.pose().translate(0, 0, 100f);
			guiGraphics.pose().scale(scale, scale, 1f);

			guiGraphics.blit(
					tabWithIcon.getIcon(),
					x,
					y,
					0, 0,
					size, size,
					size, size
			);

			guiGraphics.pose().scale(scale * 4f, scale * 4f, 1f);
			guiGraphics.pose().translate(0, 0, -100f);

			return;
		}
	}

	@Shadow(prefix = "craftory$")
	abstract int craftory$getTabX(CreativeModeTab tab);

	@Shadow(prefix = "craftory$")
	abstract int craftory$getTabY(CreativeModeTab tab);

}
