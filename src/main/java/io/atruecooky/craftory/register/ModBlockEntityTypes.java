package io.atruecooky.craftory.register;

import com.tterrag.registrate.util.entry.BlockEntityEntry;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block_entity.HeatSourceEntity;
import io.atruecooky.craftory.content.block_entity.QueryBlockEntity;
import io.atruecooky.craftory.content.entity_renderer.HeatSourceEntityRender;
import io.atruecooky.craftory.content.entity_renderer.QueryBlockEntityRender;

public class ModBlockEntityTypes {

	public static final BlockEntityEntry<HeatSourceEntity> HEAT_SOURCE = Craftory.registrate().blockEntity("heat_source", HeatSourceEntity::new)
	.validBlock(() -> ModBlocks.HEAT_SOURCE.get())
	.renderer(() -> HeatSourceEntityRender::new)
	.register();

	public static final BlockEntityEntry<QueryBlockEntity> QUERY = Craftory.registrate().blockEntity("query", QueryBlockEntity::new)
	.validBlock(() -> ModBlocks.QUERY.get())
	.renderer(() -> QueryBlockEntityRender::new)
	.register();

	public static void register() {}

}
