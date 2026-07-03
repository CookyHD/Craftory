package io.atruecooky.locomotion.heat;

import java.util.List;

import com.simibubi.create.api.equipment.goggles.IHaveHoveringInformation;

import io.atruecooky.locomotion.content.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface HeatHoverInformation extends IHaveHoveringInformation {

	@Override
	default boolean addToTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
		Player player = Minecraft.getInstance().player;
		if (!player.getInventory().hasAnyMatching(itemStack -> itemStack.is(ModItems.ENGINE_TERMOSTAT))) return false;
		addTooltip(tooltip);
		return true;
	}

	@Override
	default ItemStack getIcon(boolean isPlayerSneaking) {
		return ModItems.ENGINE_TERMOSTAT.toStack();
	}

	default void addTooltip(List<Component> tooltip) {}

}
