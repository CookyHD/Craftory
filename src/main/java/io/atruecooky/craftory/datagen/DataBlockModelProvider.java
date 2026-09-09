package io.atruecooky.craftory.datagen;

import java.util.HashMap;
import java.util.Map;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.register.data.ModModelData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataBlockModelProvider extends BlockStateProvider {
	
	public DataBlockModelProvider(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, Craftory.MODID, fileHelper);
	}

	public static final Map<Block,ModModelData.Type> ENTRIES = new HashMap<>();

	@Override
	protected void registerStatesAndModels() {

		for (Map.Entry<Block,ModModelData.Type> entry : ENTRIES.entrySet()) {
			switch (entry.getValue()) {
				case CUBE_ALL:
					Type$CUBE_ALL(entry.getKey());
					break;
				default:
					break;
			}
		}
	}

	private <T extends Block> void Type$CUBE_ALL(T block) {
		String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
		itemModels().cubeAll(name, blockTexture(block));
		getVariantBuilder(block).partialState().setModels(
			new ConfiguredModel(
				models().cubeAll(
					name,
					blockTexture(block)
				)
			)
		);
	}

	public static void addBlockModel(Block block, ModModelData.Type type) {
		if(!ENTRIES.containsKey(block)) ENTRIES.put(block, type);
	}
	
}
