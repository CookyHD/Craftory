package io.atruecooky.craftory.core.render;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import io.atruecooky.craftory.utils.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
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

	public static TextureAtlasSprite getSprite(ResourceLocation atlas, ResourceLocation texture) {
		return Minecraft.getInstance().getTextureAtlas(atlas).apply(texture);
	}

	public static void translatePixel(PoseStack poseStack, float x, float y, float z) {
		poseStack.translate(x*(1f/16f), y*(1f/16f), z*(1f/16f));
	}

	public static void rotateTube(PoseStack poseStack, BlockPos from, BlockPos to) {
		
		double dx = to.getX() - from.getX();
		double dy = to.getY() - from.getY();
		double dz = to.getZ() - from.getZ();

		double distance = Math.sqrt(dx * dx + dz * dz);

		float yaw = (float) Math.toDegrees(Math.atan2(dz, -dx));
		float pitch = (float) Math.toDegrees(Math.atan2(distance, dy));

		poseStack.mulPose(Axis.YP.rotationDegrees(yaw));
		poseStack.mulPose(Axis.ZP.rotationDegrees(pitch));

	}

	public static void rotateY(PoseStack poseStack, float degrees, double offset_x, double offset_y, double offset_z) {
		poseStack.translate(offset_x, offset_y, offset_z);
		poseStack.mulPose(Axis.YP.rotationDegrees(degrees));
		poseStack.translate(-offset_x, -offset_y, -offset_z);
	}

	public static void rotateX(PoseStack poseStack, float degrees, double offset_x, double offset_y, double offset_z) {
		poseStack.translate(offset_x, offset_y, offset_z);
		poseStack.mulPose(Axis.XP.rotationDegrees(degrees));
		poseStack.translate(-offset_x, -offset_y, -offset_z);
	}

	public static float getTime(float partialTick) {
		return Float.valueOf(Minecraft.getInstance().levelRenderer.getTicks()) + partialTick;
	}

	public static class FaceBuilder {

		public FaceBuilder () {}

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
			HORIZONTAL = {true,true,true,true,false,false},
			VERTICAL = {false,false,false,false,true,true},
			TOP = {false,false,false,false,true,false},
			BOTTOM = {false,false,false,false,false,true}
		;
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

	public static class UV {
		
		private final float u0;
		private final float u1;

		private final float v0;
		private final float v1;

		private final int width;
		private final int height;

		private float pixelSizeX() {
			return (u1 - u0) / width;
		}

		private float pixelSizeY() {
			return (v1 - v0) / height;
		}

		private UV(float u0, float u1, float v0, float v1, int width, int height) {
			this.u0 = u0;
			this.u1 = u1;
			this.v0 = v0;
			this.v1 = v1;
			this.width = width;
			this.height = height;
		}

		public static UV create(TextureAtlasSprite sprite, int width, int height) {
			return new UV(sprite.getU0(), sprite.getU1(), sprite.getV0(), sprite.getV1(), width, height);
		}

		public static UV create(float u0, float u1, float v0, float v1, int width, int height) {
			return new UV(u0, u1, v0, v1, width, height);
		}

		public float U0() {
			return u0;
		}

		public float U1() {
			return u1;
		}

		public float V0() {
			return v0;
		}

		public float V1() {
			return v1;
		}

		public int Width() {
			return width;
		}

		public int Height() {
			return height;
		}

		public UV crop(int x, int y, int w, int h) {
			return new UV(
				u0+(pixelSizeX()*x),
				u0+(pixelSizeX()*x)+(pixelSizeX()*w),
				v0+(pixelSizeY()*y),
				v0+(pixelSizeY()*y)+(pixelSizeY()*h),
				w,
				h
			);
		}
		
	}

}
