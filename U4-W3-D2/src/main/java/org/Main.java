package org;

import org.events.Event;
import org.events.EventDAO;


public class Main {
	public static void main (String[] args) {

		Event event = new Event(
			"Java Conference",
			java.time.LocalDate.of(2022, 10, 15),
			"Java Conference 2022",
			org.events.EventType.PUBLIC,
			50
		);

		// EventDAO.deleteEvent(15L);
	}
}
