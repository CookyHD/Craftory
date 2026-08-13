package io.atruecooky.craftory.content.block.entity.render;

import org.joml.Math;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block.entity.HeatSourceEntity;
import io.atruecooky.craftory.core.render.RenderHelper;
import io.atruecooky.craftory.core.render.RenderShapes;
import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;

public class HeatSourceEntityRender implements BlockEntityRenderer<HeatSourceEntity> {


	public HeatSourceEntityRender(BlockEntityRendererProvider.Context context) {}
	
	private final TextureAtlasSprite SunTexture = RenderHelper.getTexture(InventoryMenu.BLOCK_ATLAS, Craftory.namespace("block/heat_source/heat_source_sun"));

	@Override
	public void render(HeatSourceEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

		float offset = RandomSource.create(blockEntity.getBlockPos().asLong()).nextFloat() * 64;
		float time = offset + blockEntity.getLevel().getGameTime() + partialTick;

		poseStack.pushPose();

		poseStack.scale(0.25f, 0.25f, 0.25f);
		poseStack.translate(1.5f, 1.5f, 1.5f);
		
		poseStack.translate(0.5f, 0.5f, 0.5f);
		
		poseStack.mulPose(Axis.YP.rotationDegrees(4*time));
		poseStack.mulPose(Axis.XP.rotationDegrees(4*time));
		
		poseStack.translate(-0.5f,-0.5f,-0.5f);
		
		poseStack.translate(0f, Math.sin(time/4)/4, 0f);
		
		RenderShapes.cube(RenderShapes.ALL, poseStack, bufferSource, RenderType.SOLID, LightTexture.FULL_BRIGHT, 0, 16, 16, 16, SunTexture.getU0(), SunTexture.getU1(), SunTexture.getV0(), SunTexture.getV1(), Color.WHITE);
		poseStack.scale(1.2f, 1.2f, 1.2f);
		poseStack.translate(-0.1f, -0.1f, -0.1f);
		RenderShapes.cube(RenderShapes.ALL, poseStack, bufferSource, RenderType.TRANSLUCENT, LightTexture.FULL_BRIGHT, 0, 16, 16, 16, SunTexture.getU0(), SunTexture.getU1(), SunTexture.getV0(), SunTexture.getV1(), Color.WHITE.alpha(125));

		poseStack.popPose();
	}

}
