package io.atruecooky.craftory.utils;

import net.neoforged.fml.ModList;

public class ModHelper {

	//public static boolean isLoaded(String modId, Match match, String... args) {
	//	for (String string : args) {
	//		if (string.matches("^[0-9\\.]+$")) return false;
	//	}
	//	if (isLoaded(modId)) {
	//		switch (match) {
	//			case SAME:
	//				if (getVersionString(modId) != args[0]) return true;
	//				break;
	//			case LIST:
	//				for (String element : args) {
	//					if (getVersionString(modId) == element) return true;
	//				}
	//				break;
	//			case HIGHER:
	//				if (getVersion(modId).compareTo(createArtifactVersion(args[0])) >= 0) return true;
	//				break;
	//			case LOWER:
	//				if (getVersion(modId).compareTo(createArtifactVersion(args[0])) <= 0) return true;
	//				break;
	//			case BETWEEN:
	//				if (getVersion(modId).compareTo(createArtifactVersion(args[0])) >= 0 && getVersion(modId).compareTo(createArtifactVersion(args[1])) <= 0) return true;
	//				break;
	//		}
	//	}
	//	return false;
	//}

	public static boolean isLoaded(String modId) {
		return ModList.get().isLoaded(modId);
	}

	//public static @Nullable ModContainer getContainer(String modId) {
	//	if (isLoaded(modId)) return ModList.get().getModContainerById(modId).get();
	//	return null;
	//}

	//public static @Nullable ArtifactVersion getVersion(String modId) {
	//	if(getContainer(modId) != null) return getContainer(modId).getModInfo().getVersion();
	//	return null;
	//}

	//public static @Nullable String getVersionString(String modId) {
	//	if(getContainer(modId) != null) return getContainer(modId).getModInfo().getVersion().getQualifier();
	//	return null;
	//}

	//private static ArtifactVersion createArtifactVersion(String string) {
	//	return new DefaultArtifactVersion(string);
	//}

	//public enum Match {
	//	SAME,
	//	LIST,
	//	HIGHER,
	//	LOWER,
	//	BETWEEN,
	//}

}
