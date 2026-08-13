package io.atruecooky.craftory.utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.Direction;

public class Directions {

	public static final ArrayList<Direction> ALL = new ArrayList<>(List.of(
		Direction.NORTH,
		Direction.EAST,
		Direction.SOUTH,
		Direction.WEST,
		Direction.UP,
		Direction.DOWN
	));

	public static final ArrayList<Direction> COMPAS = new ArrayList<>(List.of(
		Direction.NORTH,
		Direction.EAST,
		Direction.SOUTH,
		Direction.WEST
	));
}
