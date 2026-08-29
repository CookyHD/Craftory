package io.atruecooky.craftory.utils;

import io.atruecooky.craftory.Craftory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tag {
	
	static public TagKey<Block> blockTagCommon(String name) {
		return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}

	static public TagKey<Item> itemTagCommon(String name) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}

	static public TagKey<Block> blockTag(String name) {
		return BlockTags.create(Craftory.namespace(name));
	}

	static public TagKey<Item> itemTag(String name) {
		return ItemTags.create(Craftory.namespace(name));
	}
}
