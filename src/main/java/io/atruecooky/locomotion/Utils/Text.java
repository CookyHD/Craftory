package io.atruecooky.locomotion.Utils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class Text {
	
	private MutableComponent component;
	
	private Text() {
		component = Component.empty();
	}

	public static Text of(String str) {
		Text text = new Text();
		text.component.append(str);
		return text;
	}

	public static Text black(String str) {
		return of(str).color(Color.BLACK);
	}

    public static Text dark_blue(String str) {
		return of(str).color(Color.DARK_BLUE);
	}

    public static Text dark_green(String str) {
		return of(str).color(Color.DARK_GREEN);
	}

    public static Text dark_aqua(String str) {
		return of(str).color(Color.DARK_AQUA);
	}

    public static Text dark_red(String str) {
		return of(str).color(Color.DARK_RED);
	}

    public static Text dark_purple(String str) {
		return of(str).color(Color.DARK_PURPLE);
	}

    public static Text gold(String str) {
		return of(str).color(Color.GOLD);
	}

    public static Text gray(String str) {
		return of(str).color(Color.GRAY);
	}

    public static Text dark_gray(String str) {
		return of(str).color(Color.DARK_GRAY);
	}

    public static Text blue(String str) {
		return of(str).color(Color.BLUE);
	}

    public static Text green(String str) {
		return of(str).color(Color.GREEN);
	}

    public static Text aqua(String str) {
		return of(str).color(Color.AQUA);
	}

    public static Text red(String str) {
		return of(str).color(Color.RED);
	}

    public static Text light_purple(String str) {
		return of(str).color(Color.LIGHT_PURPLE);
	}

    public static Text yellow(String str) {
		return of(str).color(Color.YELLOW);
	}

    public static Text white(String str) {
		return of(str).color(Color.WHITE);
	}

	public MutableComponent getComponent() {
		return this.component;
	}

	public Text color(int color) {
		this.component.withColor(color);
		return this;
	}

	public Text add(Text text) {
		this.component.append(text.component);
		return this;
	}

	public Text bold() {
		this.component.withStyle(ChatFormatting.BOLD);
		return this;
	}

	public Text italic() {
		this.component.withStyle(ChatFormatting.ITALIC);
		return this;
	}

	public Text strikethrough() {
		this.component.withStyle(ChatFormatting.STRIKETHROUGH);
		return this;
	}

	public Text underline() {
		this.component.withStyle(ChatFormatting.UNDERLINE);
		return this;
	}

	public Text obfuscated() {
		this.component.withStyle(ChatFormatting.OBFUSCATED);
		return this;
	}
}
