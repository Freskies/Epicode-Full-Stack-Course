package org.u5w1d5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.u5w1d5.database.*;

import java.sql.Date;

@Configuration
public class FooDataConfig {

	// BUILDINGS

	@Bean
	public Building palaciosReal() {
		return new Building("Palacios Real", "Via del Chico", "Madrid");
	}

	@Bean
	public Building colosseum() {
		return new Building("Colosseum", "Piazza del Colosseum", "Rome");
	}

	@Bean
	public Building eiffelTower() {
		return new Building("Eiffel Tower", "Champ de Mars", "Paris");
	}

	@Bean
	public Building bigBen() {
		return new Building("Big Ben", "Westminster", "London");
	}

	@Bean
	public Building statueOfLiberty() {
		return new Building("Statue of Liberty", "Liberty Island", "New York");
	}

	// WORKSTATIONS

	@Bean
	public Workstation a1() {
		return new Workstation("A1", WorkstationType.MEETING_ROOM, 100, palaciosReal());
	}

	@Bean
	public Workstation a2() {
		return new Workstation("A2", WorkstationType.OPENSPACE, 50, palaciosReal());
	}

	@Bean
	public Workstation a3() {
		return new Workstation("A3", WorkstationType.PRIVATE, 10, palaciosReal());
	}

	@Bean
	public Workstation b1() {
		return new Workstation("B1", WorkstationType.OPENSPACE, 1000, colosseum());
	}

	@Bean
	public Workstation c1() {
		return new Workstation("C1", WorkstationType.PRIVATE, 5, eiffelTower());
	}

	@Bean
	public Workstation d1() {
		return new Workstation("D1", WorkstationType.MEETING_ROOM, 50, bigBen());
	}

	@Bean
	public Workstation e1() {
		return new Workstation("E1", WorkstationType.PRIVATE, 1, statueOfLiberty());
	}

	// USERS

	@Bean
	public User user1() {
		return new User("Apotoxina052b7", "Giacchini Valerio", "portasfiga1099@gmail.com");
	}

	@Bean
	public User user2() {
		return new User("KyxPlays", "Buda Marco", "kyxplays@gmail.com");
	}

	@Bean
	public User user3() {
		return new User("PavoJ", "Paone Giovanni", "nanni2002@hotmail.com");
	}

	@Bean
	public User user4() {
		return new User("Pulpet", "Giacchini Michela", "aloic@esrever.moc");
	}

	// RESERVATIONS

	@Bean
	public Reservation reservation1() {
		return new Reservation(user4(), e1(), Date.valueOf("2025-12-25").toLocalDate());
	}

	@Bean
	public Reservation reservation2() {
		return new Reservation(user3(), c1(), Date.valueOf("2025-08-15").toLocalDate());
	}

	@Bean
	public Reservation reservation3() {
		return new Reservation(user1(), b1(), Date.valueOf("2025-06-01").toLocalDate());
	}

	@Bean
	public Reservation reservation4() {
		return new Reservation(user1(), a1(), Date.valueOf("2025-06-02").toLocalDate());
	}
}
