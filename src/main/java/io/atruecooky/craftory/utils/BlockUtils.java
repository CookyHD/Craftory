package io.atruecooky.craftory.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockUtils {

	public static BlockState getBlockAt(ServerLevel level, BlockPos pos) {
		ChunkPos chunkPos = new ChunkPos(pos);
		BlockState state;
		if (!level.hasChunk(pos.getX(),pos.getZ())) {
			level.getChunkSource().updateChunkForced(chunkPos, true);
		}
		try {
			state = level.getBlockState(pos);
		} 
		catch(Exception exception) {
			state = Blocks.AIR.defaultBlockState();
		}
		finally {
			level.getChunkSource().updateChunkForced(chunkPos, false);
		}
		return state;
	}

	public static boolean setBlockAt(ServerLevel level, BlockPos pos, BlockState blockState, int flags) {
		ChunkPos chunkPos = new ChunkPos(pos);
		boolean succses;
		if (!level.hasChunk(pos.getX(),pos.getZ())) {
			level.getChunkSource().updateChunkForced(chunkPos, true);
		}
		try {
			succses = level.setBlock(pos, blockState, flags);
		} 
		catch(Exception exception) {
			succses = false;
		}
		finally {
			level.getChunkSource().updateChunkForced(chunkPos, false);
		}
		return succses;
	}

	public static boolean destroyBlockAt(ServerLevel level, BlockPos pos, BlockState blockState, boolean drop) {
		ChunkPos chunkPos = new ChunkPos(pos);
		boolean succses;
		if (!level.hasChunk(pos.getX(),pos.getZ())) {
			level.getChunkSource().updateChunkForced(chunkPos, true);
		}
		try {
			succses = level.destroyBlock(pos, drop);
		} 
		catch(Exception exception) {
			succses = false;
		}
		finally {
			level.getChunkSource().updateChunkForced(chunkPos, false);
		}
		return succses;
	}

	public static VoxelShape createShape(double x, double y, double z, double sx, double sy, double sz) {
		return Block.box(x, y, z, x + sx, y + sy, z + sz);
	}
}
