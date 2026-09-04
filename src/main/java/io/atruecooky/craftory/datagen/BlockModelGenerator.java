package io.atruecooky.craftory.datagen;

import io.atruecooky.craftory.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModelGenerator extends BlockStateProvider {
	
	public BlockModelGenerator(PackOutput output, String modid, ExistingFileHelper fileHelper) {
		super(output, modid, fileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		block("tin_ore", ModBlocks.TIN_ORE.get());
		block("deepslate_tin_ore", ModBlocks.DEEPSLATE_TIN_ORE.get());
	}

	public <T extends Block> void block(String name, T block) {
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

	
}
