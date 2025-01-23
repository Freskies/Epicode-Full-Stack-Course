package org.database;

public enum State {
	CONFIRMED,
	PENDING;

	@Override
	public String toString () {
		return this.name().toUpperCase();
	}
}
