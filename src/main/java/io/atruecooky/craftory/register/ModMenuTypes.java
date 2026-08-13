package io.atruecooky.craftory.register;

import com.tterrag.registrate.util.entry.MenuEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.menu.WrenchMenu;
import io.atruecooky.craftory.content.screen.WrenchScreen;

public class ModMenuTypes {

	public static final MenuEntry<WrenchMenu> WRENCH_MENU = Craftory.REGISTRATE.menu("wrench_menu", WrenchMenu::new, () -> WrenchScreen::new)
	.register();

	public static void register() {}
}
