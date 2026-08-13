package io.atruecooky.craftory.content.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;


public class WrenchMenu extends AbstractContainerMenu {
	
	public WrenchMenu(MenuType<?>menuType, int containerId, Inventory inventory) {
		super(menuType, containerId);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}
}
