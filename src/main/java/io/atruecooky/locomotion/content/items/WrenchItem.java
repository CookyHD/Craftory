package io.atruecooky.locomotion.content.items;

import java.util.List;

import io.atruecooky.locomotion.Locomotion;
import io.atruecooky.locomotion.Utils.Color;
import io.atruecooky.locomotion.Utils.Text;
import io.atruecooky.locomotion.content.ModDataComponents;
import io.atruecooky.locomotion.content.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Locomotion.MODID)
public class WrenchItem extends Item {

	public class WrenchColors {
		public static final int
			PULL = Color.RED,
			PUSH = Color.BLUE,
			APPLY = Color.GREEN,
			CONFIGURE = Color.YELLOW
		;
	}

	public class WrenchModes {
		
		public static final int
			PULL = 0,
			PUSH = 1,
			APPLY = 2,
			CONFIGURE = 3
		;

		public static final int MAX_SIZE = 3;
	}

	public static WrenchItem createWithProperties() {
		Item.Properties properties = new Item.Properties();
		properties.component(ModDataComponents.WRENCH_MODE, WrenchModes.PULL);
		properties.stacksTo(1);
		return new WrenchItem(properties);
	}

	private WrenchItem(Item.Properties properties) {
		super(properties);
	};

	private static MutableComponent wrenchComponent(String text,int text_color,int color) {
		return Text.of("Mode: [").color(color).add(Text.of(text).color(text_color)).add(Text.of("]").color(color)).getComponent();
	}

	private static MutableComponent wrenchComponent(int mode,int color) {
		switch (mode) {
			case WrenchModes.PULL:
				return wrenchComponent("Pull", WrenchColors.PULL, color);
			case WrenchModes.PUSH:
				return wrenchComponent("Push", WrenchColors.PUSH, color);
			case WrenchModes.APPLY:
				return wrenchComponent("Apply", WrenchColors.APPLY, color);
			case WrenchModes.CONFIGURE:
				return wrenchComponent("Configure", WrenchColors.CONFIGURE, color);
			default:
				return wrenchComponent("Unknown", Color.GRAY, color);
		}
	}

	private static MutableComponent wrenchComponent(int mode) {
		return wrenchComponent(mode, Color.WHITE);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (hand == InteractionHand.MAIN_HAND) {
			ItemStack itemStack = player.getMainHandItem();
			int Mode = itemStack.get(ModDataComponents.WRENCH_MODE);
			Mode += 1;
			if (Mode > WrenchModes.MAX_SIZE) Mode = 0;
			if (level.isClientSide()) {
				player.displayClientMessage(wrenchComponent(Mode), true);
			}
			itemStack.set(ModDataComponents.WRENCH_MODE,Mode);
		}
		return super.use(level, player, hand);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext _context, List<Component> tooltip, TooltipFlag _flag) {
		int Mode = itemStack.get(ModDataComponents.WRENCH_MODE);
		tooltip.add(wrenchComponent(Mode,Color.DARK_GRAY));
	}

	@SubscribeEvent
	public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
		event.register((itemStack, tintIndex) -> {
			if (tintIndex != 1) return Color.WHITE;
			int Mode = itemStack.get(ModDataComponents.WRENCH_MODE);
			switch (Mode) {
				case WrenchModes.PULL:
					return WrenchColors.PULL;
				case WrenchModes.PUSH:
					return WrenchColors.PUSH;
				case WrenchModes.APPLY:
					return WrenchColors.APPLY;
				case WrenchModes.CONFIGURE:
					return WrenchColors.CONFIGURE;
				default:
					return Color.WHITE;
			}
		},
		ModItems.WRENCH);
	}
}

