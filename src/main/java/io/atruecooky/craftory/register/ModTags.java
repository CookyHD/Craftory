package io.atruecooky.craftory.register;

import io.atruecooky.craftory.register.data.ModTagData.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
	
	public static class Items {
		
		public static final TagKey<Item> TIN_ORE = TagUtils.itemTagCommon("ores/tin_ore");
		public static final TagKey<Item> RAW_MATERIALS_TIN = TagUtils.itemTagCommon("raw_materials/tin");
		
	}
	
	public static class Blocks {

		public static final TagKey<Block> MINEABLE_WRENCH = TagUtils.blockTag("mineable/wrench");

		public static final TagKey<Block> TIN_ORE = TagUtils.blockTagCommon("ores/tin_ore");
	
	}
}
