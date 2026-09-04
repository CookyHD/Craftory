package io.atruecooky.craftory.content.entity_renderer;

import org.joml.Math;

import com.mojang.blaze3d.vertex.PoseStack;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block_entity.HeatSourceEntity;
import io.atruecooky.craftory.core.render.RenderHelper;
import io.atruecooky.craftory.core.render.RenderShapes;
import io.atruecooky.craftory.core.render.RenderHelper.Faces;
import io.atruecooky.craftory.core.render.RenderHelper.UV;
import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.inventory.InventoryMenu;

public class HeatSourceEntityRender implements BlockEntityRenderer<HeatSourceEntity> {

	public HeatSourceEntityRender(BlockEntityRendererProvider.Context context) {}
	
	private final UV TEXTURE = UV.create(RenderHelper.getSprite(InventoryMenu.BLOCK_ATLAS, Craftory.namespace("block/heat_source_sun")),8,8);

	@Override
	public void render(HeatSourceEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

		float time = RenderHelper.getTime(partialTick);

		poseStack.pushPose();

		poseStack.scale(0.25f, 0.25f, 0.25f);
		poseStack.translate(1.5, 1.5, 1.5);

		poseStack.translate(0, (double)(Math.sin(time/4f)/4f), 0);

		RenderHelper.rotateY(poseStack, 4*time, 0.5, 0.5, 0.5);
		RenderHelper.rotateX(poseStack, 4*time, 0.5, 0.5, 0.5);
		
		RenderShapes.cube(Faces.ALL, poseStack, bufferSource, RenderType.SOLID, LightTexture.FULL_BRIGHT, 0, 16, 16, 16, TEXTURE, Color.WHITE);

		poseStack.scale(1.2f, 1.2f, 1.2f);
		poseStack.translate(-0.1, -0.1, -0.1);

		RenderShapes.cube(Faces.ALL, poseStack, bufferSource, RenderType.TRANSLUCENT, LightTexture.FULL_BRIGHT, 0, 16, 16, 16, TEXTURE, Color.WHITE.alpha(125));

		poseStack.popPose();
	}

}
