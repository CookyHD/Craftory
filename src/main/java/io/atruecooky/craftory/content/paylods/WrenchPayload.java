package io.atruecooky.craftory.content.paylods;

import io.atruecooky.craftory.Craftory;
import io.atruecooky.craftory.register.ModDataComponents;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public record WrenchPayload(int mode) implements CustomPacketPayload {

	public static final CustomPacketPayload.Type<WrenchPayload> TYPE = new CustomPacketPayload.Type<>(Craftory.namespace("wrench_payload"));
	
	public static final StreamCodec<ByteBuf, WrenchPayload> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT,
		WrenchPayload::mode,
		WrenchPayload::new
	);
	
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void playloadHandlers(PayloadRegistrar registrar) {
		registrar.playToServer(
			TYPE,
			STREAM_CODEC,
			(payload, context) -> {
				context.player().getMainHandItem().set(ModDataComponents.WRENCH_MODE, payload.mode);
			}
		);
	}
}
