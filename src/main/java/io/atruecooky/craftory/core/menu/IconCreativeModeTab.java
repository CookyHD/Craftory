package io.atruecooky.craftory.core.menu;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class IconCreativeModeTab extends CreativeModeTab {

	private final ResourceLocation Icon;

	private final int IconSize;

	public IconCreativeModeTab(CreativeModeTab.Builder builder, ResourceLocation icon, int iconSize) {
		super(builder);
		this.Icon = icon;
		this.IconSize = iconSize;
	}

	public ResourceLocation getIcon() {
		return this.Icon;
	}

	public int getIconSize() {
		return this.IconSize;
	}

	@Override
	public ItemStack getIconItem() {
		return ItemStack.EMPTY;
	}

}
