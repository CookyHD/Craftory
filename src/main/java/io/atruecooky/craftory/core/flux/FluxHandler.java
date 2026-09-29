package io.atruecooky.craftory.core.flux;

import net.minecraft.nbt.CompoundTag;

public class FluxHandler {
	
	private long Stored;
	private long Capacity;

	public FluxHandler(long capacity) {
		this(0L, capacity);
	}

	public FluxHandler(long amount, long capacity) {
		this.Stored = amount;
		this.Capacity = capacity;
	}

	public long insert(long amount) {
		long reminder = (this.Stored + amount) - this.Capacity;
		if (reminder > 0L) {
			this.Stored = this.Capacity;
			return reminder;
		} else {
			this.Stored += amount;
			return 0L;
		}
	}

	public long take(long amount) {
		long reminder = (this.Stored - amount);
		if (reminder < 0) {
			this.Stored = 0L;
			return Math.abs(reminder);
		} else {
			this.Stored -= amount;
			return 0L;
		}
	}

	public long getStored() {
		return this.Stored;
	}

	public void setStored(long amount) {
		this.Stored = Math.clamp(amount, 0L, this.Capacity);
	}

	public long getCapacity() {
		return this.Capacity;
	}

	public void setCapacity(long amount) {
		if (this.Stored > amount) {
			this.Stored = amount;
		}
		this.Capacity = amount;
	}

	public CompoundTag serializeNBT() {
		CompoundTag tag = new CompoundTag();
		tag.putLong("storage", this.Stored);
		return tag;
	}

	public void deserializeNBT(CompoundTag tag) {
		this.Stored = tag.getLong("storage");
	}
}
