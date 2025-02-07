package org.u5w1d5.runners;

import org.jetbrains.annotations.NotNull;
import org.u5w1d5.database.Reservation;

public class PrintHelper {
	private static final String TOP = "┌──────────────────┐";
	private static final String BOTTOM = "└──────────────────┘";

	public static void printReservations (Reservation @NotNull ... reservations) {
		System.out.println(PrintHelper.TOP);
		for (Reservation r : reservations)
			System.out.println(PrintHelper.getReservationString(r));
		System.out.println(PrintHelper.BOTTOM);
	}

	private static @NotNull String getReservationString (@NotNull Reservation r) {
		return """
			├──────────────────┤
			│ Workstation: %s
			│ Building: %s
			│   > %s, %s
			│ Date: %s
			├──────────────────┤""".formatted(
			r.getWorkstation().getDescription(),
			r.getWorkstation().getBuilding().getName(),
			r.getWorkstation().getBuilding().getAddress(),
			r.getWorkstation().getBuilding().getCity(),
			r.getReservationDate()
		);
	}
}
