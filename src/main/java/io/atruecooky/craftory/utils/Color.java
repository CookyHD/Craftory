package io.atruecooky.craftory.utils;

import net.minecraft.util.FastColor;

public class Color {

	//COLOR DEFENITIONS (taken form https://minecraft.wiki)

	public static final Color
		TRANSPARENT = fromHex("#FFFFFF00"),
		WHITE = fromHex( "#FFFFFF"),
		BLACK = fromHex("#000000"),
		DARK_BLUE = fromHex("#0000AA"),
		DARK_GREEN = fromHex("#00AA00"),
		DARK_AQUA = fromHex("#00AAAA"),
		DARK_RED = fromHex("#AA0000"),
		DARK_PURPLE = fromHex("#AA00AA"),
		GOLD = fromHex("#FFAA00"),
		GRAY = fromHex("#aaaaaa"),
		DARK_GRAY = fromHex("#555555"),
		BLUE = fromHex("#5555FF"),
		GREEN = fromHex("#55FF55"),
		AQUA = fromHex("#55FFFF"),
		RED = fromHex("#FF5555"),
		LIGHT_PURPLE = fromHex("#FF55FF"),
		YELLOW = fromHex("#FFFF55"),
		REARRITY_COMMON = WHITE,
		REARRITY_UNCOMMON = fromHex("#FFFF55"),
		REARRITY_RARE = fromHex("#55FFFF"),
		REARRITY_EPIC = fromHex("#FF55FF"),
		REARRITY_POTATO = GREEN,
		TRIM_AMETHYST = fromHex("#9A5CC6"),
		TRIM_COPPER = fromHex(" #B4684D"),
		TRIM_DIAMOND = fromHex("#6EECD2"),
		TRIM_EMERALD = fromHex("#11A036"),
		TRIM_GOLD = fromHex("#DEB12D"),
		TRIM_IRON = fromHex("#ECECEC"),
		TRIM_LAPIS = fromHex("#416E97"),
		TRIM_QUARTZ = fromHex("#E3D4C4"),
		TRIM_NETHERITE = fromHex("#625859"),
		TRIM_REDSTONE = fromHex("#971607"),
		TRIM_RESIN = fromHex("#FC7812"),
		MINECOIN_GOLD = fromHex("#DDD605"),
		PARTY_BLUE = fromHex("#8CB3FF"),
		DYE_WHITE = fromHex("#F9FFFE"),
		DYE_ORANGE = fromHex("#F9801D"),
		DYE_MAGENTA = fromHex("#C74EBD"),
		DYE_LIGHT_BLUE = fromHex("#3AB3DA"),
		DYE_YELLOW = fromHex("#FED83D"),
		DYE_LIME = fromHex("#80C71F"),
		DYE_PINK = fromHex("#F38BAA"),
		DYE_GRAY = fromHex("#474F52"),
		DYE_LIGHT_GRAY = fromHex("#9D9D97"),
		DYE_CYAN = fromHex("#169C9C"),
		DYE_PURPLE = fromHex("#8932B8"),
		DYE_BLUE = fromHex("#3C44AA"),
		DYE_BROWN = fromHex("#835432"),
		DYE_GREEN = fromHex("#5E7C16"),
		DYE_RED = fromHex("#B02E26"),
		DYE_BLACK = fromHex("#1D1D21")
	;

	//COLOR DEFENITIONS END

	public int r;
	public int g;
	public int b;
	public int a;

	public Color(int r, int g, int b, int a) {
		this.r = Math.clamp(r, 0, 255);
		this.g = Math.clamp(g, 0, 255);
		this.b = Math.clamp(b, 0, 255);
		this.a = Math.clamp(a, 0, 255);
	}

	public Color(int r, int g, int b) {
		this(r, g, b, 255);
	}

	public static Color of(int r, int g, int b, int a) {
		return new Color(r, g, b, a);
	}

	public static Color of(int r,int g,int b) {
		return of(r, g, b, 255);
	}

	public static Color fromHex(String hex) {
		
		hex = hex.trim();

		if (hex.startsWith("#")) hex = hex.substring(1);
		else if (hex.startsWith("0x")) hex = hex.substring(2);

		if (!hex.matches("^[0-9A-Fa-f]+$")) return Color.WHITE;
		switch (hex.length()) {
			case 6:
			case 8:
				break;
			default:
				return Color.WHITE;
		}

		int r = Integer.parseInt(hex.substring(0, 2), 16);
		int g = Integer.parseInt(hex.substring(2, 4), 16);
		int b = Integer.parseInt(hex.substring(4, 6), 16);

		int a = 255;

		if (hex.length() == 8) {
			a = Integer.parseInt(hex.substring(6, 8), 16);
		}

		return new Color(r, g, b, a);
	}

	public static Color fromPacked(int color) {
		return new Color(
			FastColor.ARGB32.red(color),
			FastColor.ARGB32.green(color),
			FastColor.ARGB32.blue(color),
			FastColor.ARGB32.alpha(color)
		);
	}

	public int asPacked() {
		return FastColor.ARGB32.color(a,r,g,b);
	}

	public Color darken(float amount) {
		return Color.fromPacked(
			FastColor.ARGB32.lerp(
				Math.clamp(amount, 0f, 1f),
				this.asPacked(),
				Color.BLACK.asPacked()
			)
		);
	}

	public Color lighten(float amount) {
		return Color.fromPacked(
			FastColor.ARGB32.lerp(
				Math.clamp(amount, 0f, 1f),
				this.asPacked(),
				Color.WHITE.asPacked()
			)
		);
	}

	public Color alpha(int value) {
		return new Color(this.r, this.g, this.b, value);
	}

}