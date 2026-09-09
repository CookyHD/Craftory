package io.atruecooky.craftory.datagen;

import java.util.HashMap;
import java.util.Map;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.register.data.ModModelData;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemModelProvider extends ItemModelProvider {
	
	public DataItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Craftory.MODID, existingFileHelper);
	}

	public static final Map<Item,ModModelData.Type> ENTRIES = new HashMap<>();

	@Override
	protected void registerModels() {

		for (Map.Entry<Item,ModModelData.Type> entry : ENTRIES.entrySet()) {
			switch (entry.getValue()) {
				case BASIC:
					basicItem(entry.getKey());
					break;
				case HANDHELD:
					handheldItem(entry.getKey());
					break;
				default:
					break;
			}
		}
	}

	public static void addItemModel(Item item, ModModelData.Type type) {
		if(!ENTRIES.containsKey(item)) ENTRIES.put(item, type);
	}

}
