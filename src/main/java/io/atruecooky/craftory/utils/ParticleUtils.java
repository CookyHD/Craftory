package io.atruecooky.craftory.utils;

import org.joml.Vector3d;
import org.joml.Vector3f;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

public class ParticleUtils {

	public static void spawnParticles(Level level, ParticleOptions particleOptions, Vector3d position, Vector3d size, Vector3f velocity, int count, boolean override) {
		RandomSource random = level.getRandom();
		for (int index = 0; index < count; index++) {
			double x = random.nextDouble() * size.x;
			double y = random.nextDouble() * size.y;
			double z = random.nextDouble() * size.z;
			level.addParticle(
				particleOptions,
				override,
				(position.x - (size.x / 2)) + x,
				(position.y - (size.y / 2)) + y,
				(position.z - (size.z / 2)) + z,
				velocity.x,
				velocity.y,
				velocity.z
			);
		}
	}

	public static void spawnParticles(Level level, ParticleOptions particleOptions, Vector3d position, Vector3d size, Vector3f min_velocity, Vector3f max_velocity, int min_count, int max_count, boolean override) {
		RandomSource random = level.getRandom();
		for (int index = 0; index < random.nextInt(min_count, max_count); index++) {
			double x = random.nextDouble() * size.x;
			double y = random.nextDouble() * size.y;
			double z = random.nextDouble() * size.z;
			double xV = random.nextDouble() * max_velocity.x;
			double yV = random.nextDouble() * max_velocity.y;
			double zV = random.nextDouble() * max_velocity.z;
			level.addParticle(
				particleOptions,
				override,
				(position.x - (size.x / 2)) + x,
				(position.y - (size.y / 2)) + y,
				(position.z - (size.z / 2)) + z,
				min_velocity.x + xV - min_velocity.x,
				min_velocity.y + yV - min_velocity.y,
				min_velocity.z + zV - min_velocity.z
			);
		}
	}
}
