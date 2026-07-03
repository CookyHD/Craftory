package io.atruecooky.locomotion.render;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;

import io.atruecooky.locomotion.Locomotion;
import io.atruecooky.locomotion.content.ModBlockEntitys;
import io.atruecooky.locomotion.content.block.entity.DuctEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
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
		poseStack.translate(0.5f, 2f, 0.5f);
		poseStack.scale(0.25f, 0.25f, 0.25f);
		poseStack.mulPose(new Quaternionf().rotateY((float)Math.toRadians(45d)));
		blockRenderer.renderSingleBlock(
			Blocks.DIAMOND_BLOCK.defaultBlockState(),
			poseStack,
			bufferSource,
			16,
			0,
			ModelData.EMPTY,
			RenderType.entityCutoutNoCull(ResourceLocation.fromNamespaceAndPath(Locomotion.MODID, "duct_entity"))
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

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntitys.DUCT.get(),context -> new DuctBlockEntityRender(context));
	}
}
