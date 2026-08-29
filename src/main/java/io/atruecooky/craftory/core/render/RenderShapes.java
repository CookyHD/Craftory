package io.atruecooky.craftory.core.render;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;

import io.atruecooky.craftory.core.render.RenderHelper.Faces;
import io.atruecooky.craftory.core.render.RenderHelper.Normals;
import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

public class RenderShapes {

	public static void cube(
		Boolean[] faces,
		PoseStack poseStack,
		MultiBufferSource bufferSource,
		RenderType renderType,
		int packedLight,
		int packedOverlay,
		int size_x,
		int size_y,
		int size_z,
		float u0,
		float u1,
		float v0,
		float v1,
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
		
		Vector2f uv1 = new Vector2f(u0, v1);
		Vector2f uv2 = new Vector2f(u1, v1);
		Vector2f uv3 = new Vector2f(u1, v0);
		Vector2f uv4 = new Vector2f(u0, v0);
		
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
		if (faces[0]) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv2, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv1, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv4, Normals.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv3, Normals.NORTH, color);
		}

		// EAST
		if (faces[1]) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv2, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, Normals.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv3, Normals.EAST, color);
		}

		// SOUTH
		if (faces[2]) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1, uv2, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2, uv1, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3, uv4, Normals.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4, uv3, Normals.SOUTH, color);
		}

		// WEST
		if (faces[3]) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv1, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv4, Normals.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, Normals.WEST, color);
		}

		// TOP
		if (faces[4]) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv2, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv1, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, Normals.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, Normals.TOP, color);
		}

		// BOTTOM
		if (faces[5]) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv4, Normals.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv3, Normals.BOTTOM, color);
		}
	
	}
	
	public static float tube(
		PoseStack poseStack,
		MultiBufferSource bufferSource,
		RenderType renderType,
		int packedLight,
		int packedOverlay,
		int size,
		int length,
		float u0,
		float u1,
		float v0,
		float v1,
		Color color
	) {

		float width = (float)size / 16f;

		int stpes = (int)Math.floor((float)length / (float)size);
		int reminder = (int)((float)length % (float)size);

		float y_offset = 0f;
		
		for (int i = 0; i < stpes; i++) {
			y_offset += width;
			poseStack.translate(0.0, width * i, 0.0);
			cube(Faces.COMPASS, poseStack, bufferSource, renderType, packedLight, packedOverlay, size, size, size, u0, u1, v0, v1, color);
			poseStack.translate(0.0, -(width * i), 0.0);
		}

		float pixel_size = (v1 - v0) / (float)size;

		poseStack.translate(0.0, y_offset, 0.0);
		cube(Faces.COMPASS, poseStack, bufferSource, renderType, packedLight, packedOverlay, size, size-reminder, size, u0, u1, v0+(pixel_size*reminder), v1, color);
		poseStack.translate(0.0, -y_offset, 0.0);

		return y_offset + ((float)reminder / 16f);
	}

}
