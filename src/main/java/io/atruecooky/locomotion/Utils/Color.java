package io.atruecooky.locomotion.Utils;

public class Color {

	public static final int
		WHITE = of(255,255,255),
		BLACK = of(0,0,0),
		TRANSPARENT = of(0,0,0,0),
		DARK_BLUE = of("#0000AA"),
		DARK_GREEN = of("#00AA00"),
		DARK_AQUA = of("#00AAAA"),
		DARK_RED = of("#AA0000"),
		DARK_PURPLE = of("#AA00AA"),
		GOLD = of("#FFAA00"),
		GRAY = of("#AAAAAA"),
		DARK_GRAY = of("#555555"),
		BLUE = of("#5555FF"),
		GREEN = of("#55FF55"),
		AQUA = of("#55FFFF"),
		RED = of("#FF5555"),
		LIGHT_PURPLE = of("#FF55FF"),
		YELLOW = of("#FFFF55")
	;

	public static class Bedrock {
		public static final int 
			GRAY = of("#C6C6C6"),
			MINECOIN_GOLD = of("#DDD605"),
			PARTY_BLUE = of("#8CB3FF"),
			MATERIAL_QUARTZ = of("#E3D4D1"),
			MATERIAL_IRON = of(" #CECACA"),
			MATERIAL_NETHERITE = of("#443A3B"),
			MATERIAL_REDSTONE = of("#971607"),
			MATERIAL_COPPER = of("#B4684D"),
			MATERIAL_GOLD = of("#DEB12D"),
			MATERIAL_EMERALD = of("#119F36"),
			MATERIAL_DIAMOND = of("#2CBAA8"),
			MATERIAL_LAPIS = of("#21497B"),
			MATERIAL_AMETHYST = of(" #9A5CC6"),
			MATERIAL_RESIN = of("#EB7114")
		;
	}

	public static int of(int r,int g, int b, int a) {
		String hex = "";
		hex += Integer.toHexString(Math.clamp(a, 0, 255));
		hex += Integer.toHexString(Math.clamp(r, 0, 255));
		hex += Integer.toHexString(Math.clamp(g, 0, 255));
		hex += Integer.toHexString(Math.clamp(b, 0, 255));
		return Integer.parseUnsignedInt(hex,16);
	}

	public static int of(int r,int g, int b) {
		return of(r, g, b, 255);
	}

	public static int of(float r,float g, float b, float a) {
		return of(
			(int)Math.clamp(r * 255f, 0f, 255f),
			(int)Math.clamp(g * 255f, 0f, 255f),
			(int)Math.clamp(b * 255f, 0f, 255f),
			(int)Math.clamp(a * 255f, 0f, 255f)
		);
	}

	public static int of(float r,float g, float b) {
		return of(r, g, b, 1f);
	}

	public static int of(String hex) {
		hex = hex.trim();
		if (hex.startsWith("#")) hex = hex.replace("#","");
		else if (hex.startsWith("0x")) hex = hex.replace("0x","");
		if (hex.length() == 6) hex = "FF" + hex;
		else if (hex.length() == 8) hex = hex.substring(6,8) + hex.substring(0,6);
		return Integer.parseUnsignedInt(hex,16);
	}
}