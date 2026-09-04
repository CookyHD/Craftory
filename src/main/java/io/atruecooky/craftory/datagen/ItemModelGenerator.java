package io.atruecooky.craftory.datagen;

import io.atruecooky.craftory.register.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
	
	public ItemModelGenerator(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
		super(output, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		handheldItem(ModItems.WRENCH.get());
		basicItem(ModItems.RAW_TIN.get());
	}

}
