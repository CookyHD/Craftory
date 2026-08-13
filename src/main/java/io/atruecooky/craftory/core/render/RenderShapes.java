package io.atruecooky.craftory.core.render;

import java.util.List;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;

import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

public class RenderShapes {

	public static final List<String> ALL = List.of("ALL");

	public static void cube(
		List<String> faces,
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
		if (faces.contains("NORTH") || faces.contains("ALL")) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv2, RenderHelper.NORMALS.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv1, RenderHelper.NORMALS.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv4, RenderHelper.NORMALS.NORTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv3, RenderHelper.NORMALS.NORTH, color);
		}

		// EAST
		if (faces.contains("EAST") || faces.contains("ALL")) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv2, RenderHelper.NORMALS.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, RenderHelper.NORMALS.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, RenderHelper.NORMALS.EAST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv3, RenderHelper.NORMALS.EAST, color);
		}

		// SOUTH
		if (faces.contains("SOUTH") || faces.contains("ALL")) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1, uv2, RenderHelper.NORMALS.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2, uv1, RenderHelper.NORMALS.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3, uv4, RenderHelper.NORMALS.SOUTH, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4, uv3, RenderHelper.NORMALS.SOUTH, color);
		}

		// WEST
		if (faces.contains("WEST") || faces.contains("ALL")) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, RenderHelper.NORMALS.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv1, RenderHelper.NORMALS.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv4, RenderHelper.NORMALS.WEST, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, RenderHelper.NORMALS.WEST, color);
		}

		// TOP
		if (faces.contains("TOP") || faces.contains("ALL")) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back4 , uv2, RenderHelper.NORMALS.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back3 , uv1, RenderHelper.NORMALS.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front3, uv4, RenderHelper.NORMALS.TOP, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front4, uv3, RenderHelper.NORMALS.TOP, color);
		}

		// BOTTOM
		if (faces.contains("BOTTOM") || faces.contains("ALL")) {
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front1, uv2, RenderHelper.NORMALS.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, front2, uv1, RenderHelper.NORMALS.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back2 , uv4, RenderHelper.NORMALS.BOTTOM, color);
			RenderHelper.vertex(consumer, matrix, packedLight, packedOverlay, back1 , uv3, RenderHelper.NORMALS.BOTTOM, color);
		}
	
	}

}
