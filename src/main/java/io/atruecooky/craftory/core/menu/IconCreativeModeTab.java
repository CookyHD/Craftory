package io.atruecooky.craftory.core.menu;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class IconCreativeModeTab extends CreativeModeTab {

	private final ResourceLocation Icon;

	public IconCreativeModeTab(CreativeModeTab.Builder builder, ResourceLocation icon) {
		super(builder);
		this.Icon = icon;
	}

	public ResourceLocation getIcon() {
		return this.Icon;
	}

	@Override
	public ItemStack getIconItem() {
		return ItemStack.EMPTY;
	}

}
