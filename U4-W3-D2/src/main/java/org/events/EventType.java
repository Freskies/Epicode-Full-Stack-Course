package org.events;

public enum EventType {
	PUBLIC,
	PRIVATE;

	@Override
	public String toString () {
		return this.name().toUpperCase();
	}
}
