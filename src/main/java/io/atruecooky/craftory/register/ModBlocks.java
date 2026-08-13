package io.atruecooky.craftory.register;

import com.tterrag.registrate.util.entry.BlockEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block.HeatSourceBlock;

public class ModBlocks {

	public static final BlockEntry<HeatSourceBlock> HEAT_SOURCE = Craftory.REGISTRATE.block("heat_source", HeatSourceBlock::new)
	.properties((properties) -> properties.noOcclusion().lightLevel((state) -> 8))
	.simpleItem()
	.register();

	public static void register() {}
}
