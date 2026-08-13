package io.atruecooky.craftory.core.render;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.VertexConsumer;

import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;


public class RenderHelper {

	public static VertexConsumer vertex(
		VertexConsumer consumer,
		Matrix4f matrix,
		int packedLight,
		int packedOverlay,
		Vector3f pos,
		Vector2f uv,
		Vector3f normal,
		Color color
	) {
		return consumer.addVertex(matrix, pos.x, pos.y, pos.z)
			.setUv(uv.x, uv.y)
			.setNormal(normal.x, normal.y, normal.z)
			.setLight(packedLight)
			.setOverlay(packedOverlay)
			.setColor(color.r,color.g,color.b,color.a)
		;
	}

	public final class NORMALS {
		public static final Vector3f
			NORTH  = new Vector3f(0f, 0f, -1f),
			EAST   = new Vector3f(1f, 0f, 0f),
			SOUTH  = new Vector3f(0f, 0f, 1f),
			WEST   = new Vector3f(-1f, 0f, 0f),
			TOP    = new Vector3f(0f, 1f, 0f),
			BOTTOM = new Vector3f(0f, -1f, 0f)
		;
	}

	public static TextureAtlasSprite getTexture(ResourceLocation atlas, ResourceLocation texture) {
		return Minecraft.getInstance().getTextureAtlas(atlas).apply(texture);
	}
}
