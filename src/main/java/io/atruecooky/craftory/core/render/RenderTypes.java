package io.atruecooky.craftory.core.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;

import io.atruecooky.craftory.Craftory;
import net.minecraft.client.renderer.RenderType;

public class RenderTypes {

	public static final int BUFFER_SIZE = 256;

	public static final RenderType LINES = RenderType.create(
		layername("lines"),
		DefaultVertexFormat.POSITION_COLOR,
		VertexFormat.Mode.LINES,
		BUFFER_SIZE,
		RenderType.CompositeState.builder()
			.createCompositeState(false)
	);

	private static String layername(String str) {
		return Craftory.MODID + ":" + str;
	}
}
