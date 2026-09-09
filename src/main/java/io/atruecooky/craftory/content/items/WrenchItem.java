package io.atruecooky.craftory.content.items;

import io.atruecooky.craftory.register.ModDataComponents;
import io.atruecooky.craftory.register.ModTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent.HarvestCheck;

public class WrenchItem extends Item {

	public WrenchItem(Item.Properties properties) {
		super(properties
			.component(ModDataComponents.WRENCH_MODE, 0)
			.stacksTo(1)
		);
	}

	public static void wrnechBreakSpeed(PlayerEvent.BreakSpeed event) {

		BlockState state = event.getState();
		ItemStack itemStack = event.getEntity().getMainHandItem();

		if (itemStack.is(Tags.Items.TOOLS_WRENCH) && state.is(ModTags.Blocks.MINEABLE_WRENCH)) {
			event.setNewSpeed(event.getNewSpeed() * 15.0f);
		}
	}

	public static void wrenchHravestCheck(HarvestCheck event) {

		BlockState state = event.getTargetBlock();
		ItemStack itemStack = event.getEntity().getMainHandItem();

		if (state.is(ModTags.Blocks.MINEABLE_WRENCH)) {
			if (itemStack.is(Tags.Items.TOOLS_WRENCH)) event.setCanHarvest(true);
			else event.setCanHarvest(event.canHarvest());
		}

	}


}

