package org.database;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Sex {
	M,
	F;

	@Contract (pure = true)
	@Override
	public @NotNull String toString () {
		return switch (this) {
			case M -> "Male";
			case F -> "Female";
		};
	}

	@Contract (pure = true)
	public static @Nullable Sex getInstance (@NotNull String sex) {
		return switch (sex.toUpperCase()) {
			case "M", "MALE" -> M;
			case "F", "FEMALE" -> F;
			default -> null;
		};
	}
}
