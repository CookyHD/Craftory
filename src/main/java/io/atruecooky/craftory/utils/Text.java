package io.atruecooky.craftory.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class Text {
	
	private MutableComponent component;

	private Text() {}

	private MutableComponent latest_component() {
		return ((MutableComponent)this.component.getSiblings().getLast());
	}

	static public Text of(String text) {
		Text intance = new Text();
		intance.component = Component.literal(text);
		return intance;
	}

	static public Text of_tanslate(String text) {
		Text intance = new Text();
		intance.component = Component.translatable(text);
		return intance;
	}

	public void add(String text) {
		this.component.append(Component.literal(text));
	}

	public void add_tanslate(String text) {
		this.component.append(Component.translatable(text));
	}

	public void bold() {
		latest_component().getStyle().applyFormat(ChatFormatting.BOLD);
	}

	public void italic() {
		latest_component().getStyle().applyFormat(ChatFormatting.ITALIC);
	}

	public void strikethrough() {
		latest_component().getStyle().applyFormat(ChatFormatting.STRIKETHROUGH);
	}

	public void underline() {
		latest_component().getStyle().applyFormat(ChatFormatting.UNDERLINE);
	}

	public void obfuscated() {
		latest_component().getStyle().applyFormat(ChatFormatting.OBFUSCATED);
	}

	public void color(Color color) {
		latest_component().withColor(color.asPacked());
	}

	public MutableComponent get() {
		return this.component;
	}

}
