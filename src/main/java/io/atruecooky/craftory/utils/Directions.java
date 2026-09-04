package io.atruecooky.craftory.utils;

import java.util.List;

import net.minecraft.core.Direction;

public class Directions {

	public static final List<Direction> ALL = List.of(
		Direction.NORTH,
		Direction.EAST,
		Direction.SOUTH,
		Direction.WEST,
		Direction.UP,
		Direction.DOWN
	);

	public static final List<Direction> HORIZONTAL = List.of(
		Direction.NORTH,
		Direction.EAST,
		Direction.SOUTH,
		Direction.WEST
	);
}
