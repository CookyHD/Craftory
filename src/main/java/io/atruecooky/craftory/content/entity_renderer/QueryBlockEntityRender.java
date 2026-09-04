package io.atruecooky.craftory.content.entity_renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.content.block_entity.QueryBlockEntity;
import io.atruecooky.craftory.core.render.RenderHelper;
import io.atruecooky.craftory.core.render.RenderShapes;
import io.atruecooky.craftory.core.render.RenderHelper.UV;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.phys.AABB;

public class QueryBlockEntityRender implements BlockEntityRenderer<QueryBlockEntity> {
	
	public  QueryBlockEntityRender(BlockEntityRendererProvider.Context context) {}

	private static final UV TEXTURE_UV = RenderHelper.UV.create(
		RenderHelper.getSprite(
			InventoryMenu.BLOCK_ATLAS,
			Craftory.namespace("block/block_entitys/query")
		),
		64,
		64
	);

	private static final UV GEM = TEXTURE_UV.crop(36, 28, 6, 6);
	private static final UV GEM_BOTTOM = TEXTURE_UV.crop(36, 34, 6, 6);

	private static final UV MAIN = TEXTURE_UV.crop(0, 0, 20, 20);
	private static final UV MAIN_TOP_BOTTOM = TEXTURE_UV.crop(0, 20, 20, 20);

	private static final UV PART = TEXTURE_UV.crop(20, 16, 16, 8);
	private static final UV PART_TOP = TEXTURE_UV.crop(20, 0, 16, 16);
	private static final UV PART_BOTTOM = TEXTURE_UV.crop(20, 24, 16, 16);

	private static final UV DRILL = TEXTURE_UV.crop(36, 0, 12, 16);
	private static final UV DRILL_BOTTOM = TEXTURE_UV.crop(36, 16, 12, 12);

	private static final UV FAN = TEXTURE_UV.crop(48, 16, 16, 16);
	private static final UV FAN_BACKGROUND = TEXTURE_UV.crop(48, 0, 16, 16);

	@Override
	public void render(QueryBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

		float time = RenderHelper.getTime(partialTick);
		packedLight = LightTexture.FULL_SKY;

		poseStack.pushPose();

		poseStack.translate(0, 2, 0);

		RenderHelper.translatePixel(poseStack, 5f, 0f, 5f);
		RenderShapes.cube(RenderHelper.Faces.HORIZONTAL, poseStack, bufferSource, RenderType.SOLID, LightTexture.FULL_BRIGHT, packedOverlay, 6, 6, 6, GEM);
		RenderShapes.cube(RenderHelper.Faces.BOTTOM, poseStack, bufferSource, RenderType.SOLID, LightTexture.FULL_BRIGHT, packedOverlay, 6, 6, 6, GEM_BOTTOM);

		RenderHelper.translatePixel(poseStack, -3f, 6f, -3f);
		RenderShapes.cube(RenderHelper.Faces.HORIZONTAL, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 12, 16, 12, DRILL);
		RenderShapes.cube(RenderHelper.Faces.BOTTOM, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 12, 16, 12, DRILL_BOTTOM);

		RenderHelper.translatePixel(poseStack, -2f, 16f, -2f);
		RenderShapes.cube(RenderHelper.Faces.HORIZONTAL, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 16, 8, 16, PART);
		RenderShapes.cube(RenderHelper.Faces.BOTTOM, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 16, 8, 16, PART_BOTTOM);

		RenderHelper.translatePixel(poseStack, -2f, 8f, -2f);
		RenderShapes.cube(RenderHelper.Faces.HORIZONTAL, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 20, 20, 20, MAIN);
		RenderShapes.cube(RenderHelper.Faces.VERTICAL, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 20, 20, 20, MAIN_TOP_BOTTOM);

		RenderHelper.translatePixel(poseStack, 2f, 20f, 2f);
		RenderShapes.cube(RenderHelper.Faces.HORIZONTAL, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 16, 8, 16, PART);
		RenderShapes.cube(RenderHelper.Faces.TOP, poseStack, bufferSource, RenderType.CUTOUT, packedLight, packedOverlay, 16, 8, 16, PART_TOP);

		RenderHelper.translatePixel(poseStack, 0f, 7f, 0f);
		RenderShapes.cube(RenderHelper.Faces.TOP, poseStack, bufferSource, RenderType.SOLID, packedLight, packedOverlay, 16, 0, 16, FAN_BACKGROUND);

		RenderHelper.rotateY(poseStack, -15*time, 0.5, 0.5, 0.5);

		RenderHelper.translatePixel(poseStack, 0f, 0.5f, 0f);
		RenderShapes.cube(RenderHelper.Faces.TOP, poseStack, bufferSource, RenderType.CUTOUT, packedLight, packedOverlay, 16, 0, 16, FAN);

		poseStack.popPose();
	}

	@Override
	public AABB getRenderBoundingBox(QueryBlockEntity blockEntity) {
		return AABB.INFINITE;
	}

	@Override
	public int getViewDistance() {
		return 256;
	}
	
}
