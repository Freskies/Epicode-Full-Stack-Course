package org.database;

public enum Periodicity {
	WEEKLY,
	MONTHLY,
	SEMIANNUAL;

	@Override
	public String toString () {
		return switch (this) {
			case WEEKLY -> "WEEKLY";
			case MONTHLY -> "MONTHLY";
			case SEMIANNUAL -> "SEMI-ANNUAL";
		};
	}
}
