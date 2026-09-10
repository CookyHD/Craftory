package io.atruecooky.craftory.content.block_entity;

import org.joml.Vector3d;
import org.joml.Vector3f;

import io.atruecooky.craftory.register.ModBlocks;
import io.atruecooky.craftory.utils.ParticleUtils;
import net.createmod.catnip.annotations.ClientOnly;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
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

	public int LASER_Y = 0;

	public ProgressState State;
	public ItemStackHandler Inventory;
	public int BuldingMaterial;

	@ClientOnly 
	public RandomSource random;

	public QueryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
		this.Inventory = new ItemStackHandler(6);
		this.BuldingMaterial = 0;
		this.State = ProgressState.PLAN;
		this.random = RandomSource.create(pos.asLong());
	}

	public static void tickServer(ServerLevel level, BlockPos pos, BlockState blockState, QueryBlockEntity blockEntity) {
		level.sendBlockUpdated(pos, blockState, blockState, 2);
	}

	public static void tickClient(Level level, BlockPos pos, BlockState blockState, QueryBlockEntity blockEntity) {
		double posX = pos.getX() + blockEntity.DRILL_X + 0.5;
		double posY = pos.getY() + 4.5;
		double posZ = pos.getZ() + blockEntity.DRILL_Z + 0.5;
		if (level.getGameTime() % 2 == 0) {
			ParticleUtils.spawnParticles(level, ParticleTypes.WHITE_SMOKE,
				new Vector3d(posX, posY, posZ),
				new Vector3d(0.4,0.0,0.4),
				new Vector3f(0f,0.05f,0f),
				new Vector3f(0f,0.1f,0f),
				1,
				2,
				true
			);
			ParticleUtils.spawnParticles(level, ParticleTypes.SMOKE,
				new Vector3d(posX, posY, posZ),
				new Vector3d(0.4,0.0,0.4),
				new Vector3f(0f,0.05f,0f),
				new Vector3f(0f,0.1f,0f),
				1,
				2,
				true
			);
			//for (int i = 0; i < blockEntity.random.nextInt(2, 4); i++) {
			//	level.addParticle(
			//		ParticleTypes.WHITE_SMOKE,
			//		pos.getX() + blockEntity.DRILL_X + 0.4 + (blockEntity.random.nextDouble() * 0.2),
			//		pos.getY() + 4.5,
			//		pos.getZ() + blockEntity.DRILL_Z + 0.4 + (blockEntity.random.nextDouble() * 0.2),
			//		-0.02 + blockEntity.random.nextDouble() * 0.04,
			//		0.02 + blockEntity.random.nextDouble() * 0.12,
			//		-0.02 + blockEntity.random.nextDouble() * 0.04
			//	);
			//}
			//for (int i = 0; i < blockEntity.random.nextInt(1, 2); i++) {
			//	level.addParticle(
			//		ParticleTypes.SMOKE,
			//		pos.getX() + blockEntity.DRILL_X + 0.4 + (blockEntity.random.nextDouble() * 0.2),
			//		pos.getY() + 4.5,
			//		pos.getZ() + blockEntity.DRILL_Z + 0.4 + (blockEntity.random.nextDouble() * 0.2),
			//		-0.01 + blockEntity.random.nextDouble() * 0.02,
			//		0.02 + blockEntity.random.nextDouble() * 0.12,
			//		-0.01 + blockEntity.random.nextDouble() * 0.02
			//	);
			//}
		}
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

	public int getLength() {
		return 0;
	}

	public int getWidth() {
		return 0;
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
