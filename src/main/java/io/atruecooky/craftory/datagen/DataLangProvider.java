package io.atruecooky.craftory.datagen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLangProvider extends LanguageProvider {

	public static final String MODID = Craftory.MODID;
	public static final String LOCALE = "en_us";

	public DataLangProvider(PackOutput output) {
		super(output, MODID, LOCALE);
	}

	public static final Map<String,String> ENTRIES = new HashMap<>();

	@Override
	protected void addTranslations() {

		Path file = Paths.get("").toAbsolutePath().getParent().resolve("src/main/resources/assets/"+MODID+"/lang/"+LOCALE+".json");
		
		if (Files.exists(file)) {
			try  {
				JsonObject json = new Gson().fromJson(Files.readString(file), JsonObject.class);
				json.entrySet().forEach((entry) -> {
					addTranslation(entry.getKey(), entry.getValue().getAsString());
				});
			}
			catch (Exception exception) {
				throw new RuntimeException("{}", exception);
			}
		}

		for (Map.Entry<String,String> entry : ENTRIES.entrySet()) {
			add(entry.getKey(),entry.getValue());
		}
		
	}

	public static void addTranslation(Item item, String string) {
		String key = "item."+MODID+"."+BuiltInRegistries.ITEM.getKey(item).getPath();
		if (!ENTRIES.containsKey(key)) ENTRIES.put(key, string);
	}

	public static void addTranslation(Block block, String string) {
		String key = "block."+MODID+"."+BuiltInRegistries.BLOCK.getKey(block).getPath();
		if (!ENTRIES.containsKey(key)) ENTRIES.put(key, string);
	}

	public static void addTranslation(EntityType<? extends Entity> entityType, String string) {
		String key = "entity."+MODID+"."+BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath();
		if (!ENTRIES.containsKey(key)) ENTRIES.put(key, string);
	}

	public static void addTranslation(CreativeModeTab creative_tab, String string) {
		String key = "creative_tab."+MODID+"."+BuiltInRegistries.CREATIVE_MODE_TAB.getKey(creative_tab).getPath();
		if (!ENTRIES.containsKey(key)) ENTRIES.put(key, string);
	}

	public static void addTranslation(String key, String string) {
		if (!ENTRIES.containsKey(key)) ENTRIES.put(key, string);
	}

}
