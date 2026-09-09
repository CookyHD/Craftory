package io.atruecooky.craftory;

import java.util.HashMap;
import java.util.Map;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.ModConfigSpec;

public class CraftoryConfig {
	
	public static final ModConfigSpec COMMON_SPEC;

	public static final Map<String, ModConfigSpec.BooleanValue> WORLDGEN = new HashMap<>();

	static {

		ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

		builder.push("Worldgen");

		WORLDGEN.put("tin_ore", builder
			.comment("Should generate Tin Ore")
			.define("generate_tin_ore", true)
		);

		builder.pop();

		COMMON_SPEC = builder.build();

	}

	public static boolean isWorldgenEnabled(String object) {
		if (WORLDGEN.containsKey(object)) return WORLDGEN.get(object).get();
		else return false;
	}

	public static void register(ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.COMMON, CraftoryConfig.COMMON_SPEC);
		modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
	}

}
