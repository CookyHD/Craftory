package io.atruecooky.craftory.content.block_entity;

import io.atruecooky.craftory.register.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class QueryBlockEntity extends BlockEntity {

	public static enum ProgressState {
		PLAN,
		BUILD,
		MOVE,
		MINE,
		DONE,
		ERROR,
		PAUSE
	}

	public int DRILL_X = 0;
	public int DRILL_Z = 0;

	public int LAZER_Y = 0;

	public ProgressState State;
	public ItemStackHandler Inventory;
	public int BuldingMaterial;

	public QueryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
		this.Inventory = new ItemStackHandler(6);
		this.BuldingMaterial = 0;
		this.State = ProgressState.PLAN;
	}

	public static void tickServer(Level level, BlockPos pos, BlockState blockState, QueryBlockEntity blockEntity) {
		level.sendBlockUpdated(pos, blockState, blockState, 2);
	}

	public static void tickClient(Level level, BlockPos pos, BlockState blockState, QueryBlockEntity blockEntity) {

	}

	public static boolean isFrame(Level level, BlockPos pos, Direction direction, int length) {
		for (int i = 0; i < length; i++) {
			if (!level.getBlockState(pos.relative(direction, i)).is(ModBlocks.FRAME.get())) return false;
		}
		return true;
	}

	public static class Slots {

		public int Frame() {
			return 0;
		};
	
		public int Drill() {
			return 1;
		};
	
		public int[] Upgrades() {
			final int[] arr = {2, 3, 4};
			return arr;
		}
	
		public int Extraction() {
			return 5;
		}
	}



	@Override
	protected void saveAdditional(CompoundTag tag, Provider registries) {
		tag.put("Inentory", this.Inventory.serializeNBT(registries));
		tag.putString("State", this.State.name());
	}

	@Override
	protected void loadAdditional(CompoundTag tag, Provider registries) {
		this.Inventory.deserializeNBT(registries, tag.getCompound("Inventory"));
		this.State = ProgressState.valueOf(tag.getString("State"));
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(Provider registries) {
		CompoundTag tag = new CompoundTag();
		saveAdditional(tag, registries);
		return tag;
	}

	

}
