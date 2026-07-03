package io.atruecooky.locomotion.render;

import com.mojang.blaze3d.vertex.PoseStack;

import io.atruecooky.locomotion.Locomotion;
import io.atruecooky.locomotion.content.ModBlockEntitys;
import io.atruecooky.locomotion.content.block.entity.DuctEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.model.data.ModelData;

@EventBusSubscriber(modid = Locomotion.MODID)
public class DuctBlockEntityRender implements BlockEntityRenderer<DuctEntity> {
	
	public DuctBlockEntityRender (BlockEntityRendererProvider.Context context) {}

	@Override
	public void render(DuctEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
		poseStack.pushPose();
		poseStack.translate(0f, 2f, 0f);
		blockRenderer.renderSingleBlock(
			Blocks.DIAMOND_BLOCK.defaultBlockState(),
			poseStack,
			bufferSource,
			2000,
			0,
			ModelData.EMPTY,
			RenderType.SOLID
		);
		poseStack.popPose();
	}

	@Override
	public boolean shouldRender(DuctEntity blockEntity, Vec3 cameraPos) {
		return true;
	}

	@Override
	public boolean shouldRenderOffScreen(DuctEntity blockEntity) {
		return true;
	}

	private int getLightLevel(Level level, BlockPos pos) {
		int block_light = level.getBrightness(LightLayer.BLOCK, pos);
		int sky_light = level.getBrightness(LightLayer.SKY, pos);
		return LightTexture.pack(block_light, sky_light);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntitys.DUCT.get(),context -> new DuctBlockEntityRender(context));;
	}
}
