package io.atruecooky.craftory.register;

import com.tterrag.registrate.util.entry.BlockEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block.HeatSourceBlock;
import io.atruecooky.craftory.content.block.PipeBlock;
import io.atruecooky.craftory.content.block.QueryBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

	public static final BlockEntry<HeatSourceBlock> HEAT_SOURCE = Craftory.registrate().block("heat_source", HeatSourceBlock::new)
	.properties((properties) -> properties
		.noOcclusion()
		.lightLevel((state) -> 8)
		.strength(2f, 2f)
		.sound(SoundType.METAL)
		.mapColor(DyeColor.PURPLE)
	)
	.simpleItem()
	.register();

	public static final BlockEntry<PipeBlock> FRAME = Craftory.registrate().block("frame", PipeBlock::new)
	.properties((properties) -> properties
		.strength(1f, 1f)
		.mapColor(DyeColor.ORANGE)
		.sound(SoundType.LANTERN)
	)
	.simpleItem()
	.register();

	public static final BlockEntry<QueryBlock> QUERY = Craftory.registrate().block("query", QueryBlock::new)
	.properties((properties) -> properties
		.strength(2f, 2f)
		.mapColor(DyeColor.GRAY)
		.sound(SoundType.METAL)
	)
	.simpleItem()
	.register();

	public static final BlockEntry<Block> TIN_ORE = Craftory.registrate().block("tin_ore", Block::new)
	.properties((properties) -> properties
		.strength(3f, 3f)
		.requiresCorrectToolForDrops()
		.mapColor(MapColor.STONE)
		.sound(SoundType.STONE)
		.instrument(NoteBlockInstrument.BASEDRUM)
	)
	.simpleItem()
	.register();

	public static final BlockEntry<Block> DEEPSLATE_TIN_ORE = Craftory.registrate().block("deepslate_tin_ore", Block::new)
	.properties((properties) -> properties
		.strength(4.5f, 3f)
		.requiresCorrectToolForDrops()
		.mapColor(MapColor.DEEPSLATE)
		.sound(SoundType.DEEPSLATE)
		.instrument(NoteBlockInstrument.BASEDRUM)
	)
	.simpleItem()
	.register();

	public static void register() {}
}
