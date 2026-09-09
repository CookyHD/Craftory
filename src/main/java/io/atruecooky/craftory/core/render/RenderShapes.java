package io.atruecooky.craftory.core.render;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;

import io.atruecooky.craftory.core.render.RenderHelper.CullMode;
import io.atruecooky.craftory.core.render.RenderHelper.Faces;
import io.atruecooky.craftory.core.render.RenderHelper.Normals;
import io.atruecooky.craftory.core.render.RenderHelper.UV;
import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

public class RenderShapes {

	public static void cube(
		Boolean[] faces,
		CullMode cull,
		PoseStack poseStack,
		MultiBufferSource bufferSource,
		RenderType renderType,
		int packedLight,
		int packedOverlay,
		int size_x,
		int size_y,
		int size_z,
		UV uv
	) {
		cube(faces, cull, poseStack, bufferSource, renderType, packedLight, packedOverlay, size_x, size_y, size_z, uv, Color.WHITE);
	}

	public static void cube(
		Boolean[] faces,
		CullMode cull,
		PoseStack poseStack,
		MultiBufferSource bufferSource,
		RenderType renderType,
		int packedLight,
		int packedOverlay,
		int size_x,
		int size_y,
		int size_z,
		UV uv,
		Color color
	) {

		if (renderType.mode != VertexFormat.Mode.QUADS) return;

		if (!renderType.format.contains(VertexFormatElement.POSITION)) return;
		if (!renderType.format.contains(VertexFormatElement.COLOR)) return;
		if (!renderType.format.contains(VertexFormatElement.UV0)) return;
		if (!renderType.format.contains(VertexFormatElement.NORMAL)) return;

		float xf = (float)size_x / 16f;
		float yf = (float)size_y / 16f;
		float zf = (float)size_z / 16f;
		
		Vector2f uv1 = new Vector2f(uv.U0(), uv.V1());
		Vector2f uv2 = new Vector2f(uv.U1(), uv.V1());
		Vector2f uv3 = new Vector2f(uv.U1(), uv.V0());
		Vector2f uv4 = new Vector2f(uv.U0(), uv.V0());
		
		Vector3f front1 = new Vector3f(0f,0f,0f);
		Vector3f front2 = new Vector3f(xf,0f,0f);
		Vector3f front3 = new Vector3f(xf,yf,0f);
		Vector3f front4 = new Vector3f(0f,yf,0f);

		Vector3f back1 = new Vector3f(0f,0f,zf);
		Vector3f back2 = new Vector3f(xf,0f,zf);
		Vector3f back3 = new Vector3f(xf,yf,zf);
		Vector3f back4 = new Vector3f(0f,yf,zf);
		
		Matrix4f matrix = poseStack.last().pose();
		VertexConsumer consumer = bufferSource.getBuffer(renderType);

		// NORTH
		if (faces[0] && (cull == CullMode.BACK || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv2, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv1, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv4, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv3, Normals.NORTH, color);
		}

		if (faces[0] && (cull == CullMode.FRONT || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, Normals.SOUTH, color);
		}

		// EAST
		if (faces[1] && (cull == CullMode.BACK || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv2, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv3, Normals.EAST, color);
		}

		if (faces[1] && (cull == CullMode.FRONT || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv2, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv1, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv4, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv3, Normals.WEST, color);
		}

		// SOUTH
		if (faces[2] && (cull == CullMode.BACK || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1, uv2, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2, uv1, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3, uv4, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4, uv3, Normals.SOUTH, color);
		}

		if (faces[2] && (cull == CullMode.FRONT || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2, uv2, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1, uv1, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4, uv4, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3, uv3, Normals.NORTH, color);
		}

		// WEST
		if (faces[3] && (cull == CullMode.BACK || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv1, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv4, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, Normals.WEST, color);
		}

		if (faces[3] && (cull == CullMode.FRONT || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv2, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv1, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv4, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv3, Normals.EAST, color);
		}

		// TOP
		if (faces[4] && (cull == CullMode.BACK || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv2, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv1, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, Normals.TOP, color);
		}

		if (faces[4] && (cull == CullMode.FRONT || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv2, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv1, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv4, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv3, Normals.BOTTOM, color);
		}

		// BOTTOM
		if (faces[5] && (cull == CullMode.BACK || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv4, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv3, Normals.BOTTOM, color);
		}

		if (faces[5] && (cull == CullMode.FRONT || cull == CullMode.NONE)) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv2, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv1, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv4, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv3, Normals.TOP, color);
		}
	
	}
	
	public static float tube(
		CullMode cull,
		PoseStack poseStack,
		MultiBufferSource bufferSource,
		RenderType renderType,
		int packedLight,
		int packedOverlay,
		int size,
		int length,
		UV uv
	) {
		return tube(cull, poseStack, bufferSource, renderType, packedLight, packedOverlay, size, length, uv, Color.WHITE);
	}

	public static float tube(
		CullMode cull,
		PoseStack poseStack,
		MultiBufferSource bufferSource,
		RenderType renderType,
		int packedLight,
		int packedOverlay,
		int size,
		int length,
		UV uv,
		Color color
	) {

		float width = (float)size / 16f;

		int stpes = (int)Math.floor((float)length / (float)size);
		int reminder = (int)((float)length % (float)size);

		float y_offset = 0f;
		
		for (int i = 0; i < stpes; i++) {
			y_offset += width;
			poseStack.translate(0.0, width * i, 0.0);
			cube(Faces.HORIZONTAL, cull, poseStack, bufferSource, renderType, packedLight, packedOverlay, size, size, size, uv, color);
			poseStack.translate(0.0, -(width * i), 0.0);
		}

		UV last_uv = uv.crop(0, 0, uv.Width(), reminder);

		poseStack.translate(0.0, y_offset, 0.0);
		cube(Faces.HORIZONTAL, cull, poseStack, bufferSource, renderType, packedLight, packedOverlay, size, size-reminder, size, last_uv, color);
		poseStack.translate(0.0, -y_offset, 0.0);

		return y_offset + ((float)reminder / 16f);
	}

}
