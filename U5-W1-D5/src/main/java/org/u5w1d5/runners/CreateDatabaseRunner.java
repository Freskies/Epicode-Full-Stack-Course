package org.u5w1d5.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.u5w1d5.database.*;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order (1)
public class CreateDatabaseRunner implements CommandLineRunner {
	// REPOSITORY
	private final BuildingRepository buildingRepository;
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;
	private final WorkstationRepository workstationRepository;

	// BUILDINGS
	private final Building palaciosReal;
	private final Building colosseum;
	private final Building eiffelTower;
	private final Building bigBen;
	private final Building statueOfLiberty;

	// WORKSTATIONS
	private final Workstation a1;
	private final Workstation a2;
	private final Workstation a3;
	private final Workstation b1;
	private final Workstation c1;
	private final Workstation d1;
	private final Workstation e1;

	// USERS
	private final User user1;
	private final User user2;
	private final User user3;
	private final User user4;

	// RESERVATIONS
	private final Reservation reservation1;
	private final Reservation reservation2;

	@Override
	public void run (String... args) {
		System.out.println("Creating database...");

		System.out.println(" > Creating buildings...");
		buildingRepository.saveAll(
			List.of(this.palaciosReal, this.colosseum, this.eiffelTower, this.bigBen, this.statueOfLiberty)
		);

		System.out.println(" > Creating workstations...");
		workstationRepository.saveAll(
			List.of(this.a1, this.a2, this.a3, this.b1, this.c1, this.d1, this.e1)
		);

		System.out.println(" > Creating users...");
		userRepository.saveAll(
			List.of(this.user1, this.user2, this.user3, this.user4)
		);

		System.out.println(" > Creating reservations...");
		reservationRepository.saveAll(
			List.of(this.reservation1, this.reservation2)
		);

		System.out.println("Database created!");
	}
}
