package io.atruecooky.craftory.register;

import com.tterrag.registrate.util.entry.BlockEntityEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block.entity.HeatSourceEntity;
import io.atruecooky.craftory.content.block.entity.render.HeatSourceEntityRender;

public class ModBlockEntityTypes {

	public static final BlockEntityEntry<HeatSourceEntity> HEAT_SOURCE = Craftory.REGISTRATE.blockEntity("heat_source", HeatSourceEntity::new)
	.validBlock(() -> ModBlocks.HEAT_SOURCE.get())
	.renderer(() -> HeatSourceEntityRender::new)
	.register();

	public static void register() {}

}
