package io.atruecooky.craftory.utils;

import io.atruecooky.craftory.Craftory;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockUtils {

	public static BlockState getBlockAt(ServerLevel level, BlockPos pos) {
		try {
			level.getChunk(pos);
			return  level.getBlockState(pos);
		} 
		catch(Exception exception) {
			Craftory.LOG.error("{}", exception);
			return Blocks.AIR.defaultBlockState();
		}
	}

	public static boolean setBlockAt(ServerLevel level, BlockPos pos, BlockState blockState, int flags) {
		try {
			level.getChunk(pos);
			return level.setBlock(pos, blockState, flags);
		} 
		catch(Exception exception) {
			Craftory.LOG.error("{}", exception);
			return false;
		}
	}
	public static boolean destroyBlockAt(ServerLevel level, BlockPos pos, boolean drop) {
		try {
			level.getChunk(pos);
			return level.destroyBlock(pos, drop);
		} 
		catch(Exception exception) {
			Craftory.LOG.error("{}", exception);
			return false;
		}
	}

	public static VoxelShape createShape(double x, double y, double z, double sx, double sy, double sz) {
		return Block.box(x, y, z, x + sx, y + sy, z + sz);
	}
}
