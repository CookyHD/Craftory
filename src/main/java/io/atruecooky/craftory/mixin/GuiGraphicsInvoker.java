package io.atruecooky.craftory.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

@Mixin(GuiGraphics.class)
public interface GuiGraphicsInvoker {

	@Invoker("innerBlit")
	public void craftory$innerBlit(
		ResourceLocation atlasLocation,
		int x1,
		int x2,
		int y1,
		int y2,
		int blitOffset,
		float minU,
		float maxU,
		float minV,
		float maxV
	);

}