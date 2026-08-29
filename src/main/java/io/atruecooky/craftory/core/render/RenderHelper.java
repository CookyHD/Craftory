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

	public static TextureAtlasSprite getTexture(ResourceLocation atlas, ResourceLocation texture) {
		return Minecraft.getInstance().getTextureAtlas(atlas).apply(texture);
	}

	public static class FaceBuilder {

		protected FaceBuilder () {}

		private Boolean[] faces = {false,false,false,false,false,false};

		public Boolean[] build() {
			return this.faces;
		}

		public FaceBuilder north() {
			this.faces[0] = true;
			return this;
		}

		public FaceBuilder east() {
			this.faces[1] = true;
			return this;
		}

		public FaceBuilder south() {
			this.faces[2] = true;
			return this;
		}

		public FaceBuilder west() {
			this.faces[3] = true;
			return this;
		}

		public FaceBuilder top() {
			this.faces[4] = true;
			return this;
		}

		public FaceBuilder bottom() {
			this.faces[5] = true;
			return this;
		}
	}

	public final class Faces {
		public static final Boolean[] 
			ALL = {true,true,true,true,true,true},
			COMPASS = {true,true,true,true,false,false}
		;

		public static FaceBuilder builder() {
			return new FaceBuilder();
		}
	}

	public final class Normals {
		public static final Vector3f
			NORTH  = new Vector3f(0f, 0f, -1f),
			EAST   = new Vector3f(1f, 0f, 0f),
			SOUTH  = new Vector3f(0f, 0f, 1f),
			WEST   = new Vector3f(-1f, 0f, 0f),
			TOP    = new Vector3f(0f, 1f, 0f),
			BOTTOM = new Vector3f(0f, -1f, 0f)
		;
	}

}
