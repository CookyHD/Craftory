package io.atruecooky.craftory.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

@Mixin(AbstractContainerScreen.class)
public interface ContainerScreenAccessor {
	
	@Accessor("leftPos")
	public int craftory$getLeftPos();

	@Accessor("topPos")
	public int craftory$getTopPos();

}
