package io.atruecooky.craftory.datagen;

import com.tterrag.registrate.util.entry.BlockEntry;

import io.atruecooky.craftory.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModelGenerator extends BlockStateProvider {
	
	public BlockModelGenerator(PackOutput output, String modid, ExistingFileHelper fileHelper) {
		super(output, modid, fileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlock(ModBlocks.TIN_ORE);
		this.simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE);
	}

	public <T extends Block> void simpleBlock(BlockEntry<T> entry) {
		T block = entry.get();
		String id = entry.getId().getPath();
		ModelFile model = this.models().cubeAll(id, this.blockTexture(block));
		this.itemModels().cubeAll(id, this.blockTexture(block));
		this.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(model));
	}

	
}
