package io.atruecooky.craftory.core.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

public class MenuHelper {
	
	public static <T extends AbstractContainerMenu> void addStandardInventorySlots(T menu, Inventory playerInventory, int x, int y) {
		for (int hot_slot = 0; hot_slot < 9; ++hot_slot) {
			menu.slots.add(new Slot(playerInventory, hot_slot, x + hot_slot * 18, y + 58));
		}
		for (int row = 0; row < 3; ++row) {
			for (int slot = 0; slot < 9; ++slot) {
				menu.slots.add(new Slot(playerInventory, slot + row * 9 + 9, x + slot * 18, y + row * 18));
			}
		}
	}
}
