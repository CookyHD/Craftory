package io.atruecooky.craftory.register;

import com.tterrag.registrate.util.entry.BlockEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block.HeatSourceBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

	public static final BlockEntry<HeatSourceBlock> HEAT_SOURCE = Craftory.REGISTRATE.block("heat_source", HeatSourceBlock::new)
	.properties((properties) -> properties.noOcclusion().lightLevel((state) -> 8))
	.simpleItem()
	.register();

	public static final BlockEntry<Block> TIN_ORE = createOreBlock("tin_ore", 3f, 3f);
	public static final BlockEntry<Block> LEAD_ORE = createOreBlock("lead_ore", 3f, 3f);
	public static final BlockEntry<Block> TSILVER_ORE = createOreBlock("silver_ore", 3f, 3f);
	public static final BlockEntry<Block> THUNGSTON_ORE = createOreBlock("thungston_ore", 3f, 3f);

	public static final BlockEntry<Block> DEEPSLATE_TIN_ORE = createOreBlock("deepslate_tin_ore", 4.5f, 3f);
	public static final BlockEntry<Block> DEEPSLATE_LEAD_ORE = createOreBlock("deepslate_lead_ore", 4.5f, 3f);
	public static final BlockEntry<Block> DEEPSLATE_TSILVER_ORE = createOreBlock("deepslate_silver_ore", 4.5f, 3f);
	public static final BlockEntry<Block> DEEPSLATE_THUNGSTON_ORE = createOreBlock("deepslate_thungston_ore", 4.5f, 3f);
	
	public static final BlockEntry<DropExperienceBlock> URANIUM_ORE = createOreBlock("uranium_ore", 3f, 3f, 1, 2);
	public static final BlockEntry<DropExperienceBlock> DEEPSLATE_URANIUM_ORE = createOreBlock("deepslate_uranium_ore", 4.5f, 3f, 1, 2);

	public static BlockEntry<Block> createOreBlock(String name, float strength, float hardness) {
		return Craftory.REGISTRATE.block(name, Block::new)
		.properties((properties) -> properties
			.sound(SoundType.STONE)
			.instrument(NoteBlockInstrument.BASEDRUM)
			.mapColor(MapColor.STONE)
			.strength(strength, hardness)
			.requiresCorrectToolForDrops()
		)
		.simpleItem()
		.register();
	}

	public static BlockEntry<DropExperienceBlock> createOreBlock(String name, float strength, float hardness, int min_xp, int max_xp) {
		return Craftory.REGISTRATE.block(name, (properties) -> new DropExperienceBlock(
				UniformInt.of(min_xp, max_xp),
				properties
			)
		)
		.properties((properties) -> properties
			.sound(SoundType.STONE)
			.instrument(NoteBlockInstrument.BASEDRUM)
			.mapColor(MapColor.STONE)
			.strength(strength, hardness)
			.requiresCorrectToolForDrops()
		)
		.simpleItem()
		.register();
	}

	public static void register() {}
}
