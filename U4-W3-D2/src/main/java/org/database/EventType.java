package org.database;

public enum EventType {
	PUBLIC,
	PRIVATE;

	@Override
	public String toString () {
		return this.name().toUpperCase();
	}
}
