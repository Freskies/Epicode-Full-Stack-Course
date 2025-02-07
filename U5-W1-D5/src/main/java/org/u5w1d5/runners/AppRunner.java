package org.u5w1d5.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.u5w1d5.database.*;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
@Order (2)
public class AppRunner implements CommandLineRunner {

	// REPOSITORY
	private final BuildingRepository buildingRepository;
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;
	private final WorkstationRepository workstationRepository;

	// SCANNER
	private static final Scanner scanner = new Scanner(System.in);

	private static String scan () {
		return scanner.nextLine();
	}

	@Override
	public void run (String... args) {
		this.loginMenu();
	}

	// LOGIN

	/**
	 * <h1>Login Menu</h1>
	 * <p>1. Login</p>
	 * <p>2. Register</p>
	 * <p>0. Exit</p>
	 */
	public void loginMenu () {
		System.out.print("""
			------------------
			1. Login
			2. Register
			0. Exit
			->\s""");

		switch (scan()) {
			case "1" -> this.login();
			case "2" -> this.register();
			case "0" -> System.exit(0);
			default -> this.loginMenu();
		}
	}

	/**
	 * Ask for username and check if exists.
	 * If exists, go to main menu
	 */
	public void login () {
		String username = this.askUsername();
		if (userRepository.existsByUsername(username))
			this.mainMenu(userRepository.findByUsername(username));
		else {
			System.out.println("\tUser not found!");
			this.loginMenu();
		}
	}

	/**
	 * Register a new user and go to main menu
	 */
	public void register () {
		String username = this.askUsername();
		if (userRepository.existsByUsername(username)) {
			System.out.println("\tUsername already exists!");
			this.register();
		} else {
			String fullName = this.askFullName();
			String email = this.askEmail();
			userRepository.save(new User(username, fullName, email));
			this.mainMenu(userRepository.findByUsername(username));
		}
	}

	/**
	 * Ask for username until is valid
	 * A valid username is not empty and at least 5 characters long
	 *
	 * @return username
	 */
	public String askUsername () {
		System.out.print("\tEnter your username: ");
		String username = scan();
		if (username.isBlank()) {
			System.out.println("\tUsername cannot be empty!");
			return this.askUsername();
		}
		if (username.length() < 5) {
			System.out.println("\tUsername must contain at least 5 characters!");
			return this.askUsername();
		}
		return username;
	}

	/**
	 * Ask for full name until is valid
	 * A valid full name is not empty, contains only letters and spaces,
	 * contains at least 2 words and at least 5 characters long
	 *
	 * @return full name
	 */
	public String askFullName () {
		System.out.print("\tEnter your full name: ");
		String fullName = scan();
		if (fullName.isBlank()) {
			System.out.println("\tFull name cannot be empty!");
			return this.askFullName();
		}
		if (!fullName.matches("^[a-zA-Z ]+$")) {
			System.out.println("\tFull name can contain only letters and spaces!");
			return this.askFullName();
		}
		if (!fullName.contains(" ")) {
			System.out.println("\tFull name must contain at least 2 words!");
			return this.askFullName();
		}
		if (fullName.length() < 5) {
			System.out.println("\tFull name must contain at least 5 characters!");
			return this.askFullName();
		}
		return fullName;
	}

	/**
	 * Ask for email until is valid
	 * A valid email is not empty and has a valid email format
	 *
	 * @return email
	 */
	public String askEmail () {
		System.out.print("\tEnter your email: ");
		String email = scan();
		if (email.isBlank()) {
			System.out.println("\tEmail cannot be empty!");
			return this.askEmail();
		}
		if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			System.out.println("\tInvalid email format!");
			return this.askEmail();
		}
		return email;
	}

	// APPLICATION

	/**
	 * <h1>Main Menu</h1>
	 * <p>1. New Reservation</p>
	 * <p>2. My Reservations</p>
	 * <p>0. Logout</p>
	 */
	public void mainMenu (User loggedUser) {
		System.out.print("""
			##################
			1. New Reservation
			2. My Reservations
			0. Logout
			->\s""");

		switch (scan()) {
			case "1" -> this.newReservation(loggedUser);
			case "2" -> this.myReservations(loggedUser);
			case "0" -> this.loginMenu();
			default -> this.mainMenu(loggedUser);
		}
	}

	private void newReservation (User loggedUser) {

	}

	/**
	 * Print all reservations of the logged user
	 * @param loggedUser the user logged in
	 */
	private void myReservations (User loggedUser) {
		List<Reservation> reservations = reservationRepository.findByUser(loggedUser);
		PrintHelper.printReservations(reservations.toArray(new Reservation[0]));
	}


}
