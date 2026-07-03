package io.atruecooky.locomotion.content.block.entity;

import java.util.List;

import io.atruecooky.locomotion.Utils.Text;
import io.atruecooky.locomotion.content.ModBlockEntitys;
import io.atruecooky.locomotion.heat.HeatHoverInformation;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SlagCollectorEntity extends BlockEntity implements HeatHoverInformation {

	private int ProccesTime = 0;
	private int MaxProccesTime = 100;

	@Override
	public void addTooltip(List<Component> tooltip) {
		tooltip.add(Text.of("    Heat Display:").getComponent());
	}

	public SlagCollectorEntity(BlockPos pos,BlockState state) {
		super(ModBlockEntitys.SLAG_COLLECTOR.get(), pos, state);
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T blockEntity) {
		
	};
}
