package io.atruecooky.craftory.content.block;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class WoodenBlocks {

	public static final Map<BlockState,BlockState> STRIPPED_MAP = new HashMap<>();

	public static class FlamableLog extends RotatedPillarBlock {

		public static final MapCodec<FlamableLog> CODEC = BlockBehaviour.simpleCodec(FlamableLog::new);

		@Override
		public MapCodec<FlamableLog> codec() {
			return CODEC;
		}
	
		public FlamableLog(BlockBehaviour.Properties properties) {
			super(properties);
		}
	
		@Override
		public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return true; 
		}
	
		@Override
		public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
			if (STRIPPED_MAP.containsKey(state)) {
				BlockState stripped = STRIPPED_MAP.get(state);
				if (itemAbility == ItemAbilities.AXE_STRIP) {
					return stripped.setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
				}
			}
			return super.getToolModifiedState(state, context, itemAbility, simulate);
		}
	}

	public static class FlameablePlanks extends Block {

		public static final MapCodec<FlameablePlanks> CODEC = BlockBehaviour.simpleCodec(FlameablePlanks::new);

		@Override
		public MapCodec<FlameablePlanks> codec() {
			return CODEC;
		}

		public FlameablePlanks(BlockBehaviour.Properties properties) {
			super(properties);
		}

		@Override
		public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return true; 
		}
		
	}

	public static class FlameableLeaves extends LeavesBlock {

		public static final MapCodec<FlameableLeaves> CODEC = BlockBehaviour.simpleCodec(FlameableLeaves::new);

		@Override
		public MapCodec<FlameableLeaves> codec() {
			return CODEC;
		}

		public FlameableLeaves(BlockBehaviour.Properties properties) {
			super(properties);
		}

		@Override
		public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return true; 
		}
		
	}

	public static class FlamableStair extends StairBlock {

		public static final MapCodec<FlamableStair> CODEC = RecordCodecBuilder.mapCodec(
			builder -> builder.group(BlockState.CODEC.fieldOf("base_state").forGetter(state -> state.baseState), propertiesCodec()).apply(builder, FlamableStair::new)
		);

		@Override
		public MapCodec<FlamableStair> codec() {
			return CODEC;
		}

		public FlamableStair(BlockState baseState, BlockBehaviour.Properties properties) {
			super(baseState, properties);
		}

		@Override
		public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return true; 
		}

	}

	public static class FlamableSlab extends SlabBlock {

		public static final MapCodec<FlamableSlab> CODEC = BlockBehaviour.simpleCodec(FlamableSlab::new);

		@Override
		public MapCodec<FlamableSlab> codec() {
			return CODEC;
		}

		public FlamableSlab(BlockBehaviour.Properties properties) {
			super(properties);
		}

		@Override
		public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return true; 
		}

	}

	public static class FlamableFence extends FenceBlock {

		public static final MapCodec<FenceBlock> CODEC = BlockBehaviour.simpleCodec(FenceBlock::new);

		@Override
		public MapCodec<FenceBlock> codec() {
			return CODEC;
		}

		public FlamableFence(BlockBehaviour.Properties properties) {
			super(properties);
		}

		@Override
		public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return 5;
		}
	
		@Override
		public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
			return true; 
		}
		
	}

	public static void registerStripped(BlockState log, BlockState stripped_log) {
		STRIPPED_MAP.put(log, stripped_log);
	}
	
}
