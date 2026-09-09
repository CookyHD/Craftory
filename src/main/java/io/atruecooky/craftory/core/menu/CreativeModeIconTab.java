package io.atruecooky.craftory.core.menu;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.utils.Text;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeIconTab extends CreativeModeTab {

	private final ResourceLocation Icon;

	public CreativeModeIconTab(ResourceLocation location, CreativeModeTab.Builder builder) {
		super(builder.title(Text.of_tanslate("creative_tab."+location.getNamespace()+"."+location.getPath()).get()));
		this.Icon = Craftory.namespace("textures/gui/icon/none.png");
	}

	public CreativeModeIconTab(ResourceLocation location, CreativeModeTab.Builder builder, ResourceLocation icon) {
		super(builder.title(Text.of_tanslate("creative_tab."+location.getNamespace()+"."+location.getPath()).get()));
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
