package org.u5w1d5.runners;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.u5w1d5.database.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
@Order (2)
public class AppRunner implements CommandLineRunner {
	private final BuildingRepository buildingRepository;
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;
	private final WorkstationRepository workstationRepository;

	private static final Scanner scanner = new Scanner(System.in);

	private static String scan () {
		return scanner.nextLine();
	}

	/**
	 * <h1>Run</h1>
	 *
	 * @param args incoming main method arguments
	 */
	@Override
	public void run (String... args) {
		this.loginMenu();
	}

	/**
	 * <h2>Login Menu</h2>
	 * <p>1. Login</p>
	 * <p>2. Register</p>
	 * <p>0. Exit</p>
	 */
	private void loginMenu () {
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
	 * <h3>Login</h3>
	 * Ask for username and check if exists.
	 * If exists, go to main menu
	 */
	private void login () {
		String username = this.askUsername();
		if (userRepository.existsByUsername(username))
			this.mainMenu(userRepository.findByUsername(username));
		else {
			System.out.println("\tUser not found!");
			this.loginMenu();
		}
	}

	/**
	 * <h3>Register</h3>
	 * Register a new user and go to main menu
	 */
	private void register () {
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
	private @NotNull String askUsername () {
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
	private @NotNull String askFullName () {
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
	private @NotNull String askEmail () {
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

	/**
	 * <h2>Main Menu</h2>
	 * <p>1. New Reservation</p>
	 * <p>2. My Reservations</p>
	 * <p>0. Logout</p>
	 */
	private void mainMenu (@NotNull User loggedUser) {
		System.out.printf("""
			##################
			WELCOME %s!
			1. New Reservation
			2. My Reservations
			0. Logout
			->\s""", loggedUser.getUsername());

		switch (scan()) {
			case "1" -> this.newReservation(loggedUser);
			case "2" -> this.myReservations(loggedUser);
			case "0" -> this.loginMenu();
			default -> this.mainMenu(loggedUser);
		}
	}

	/**
	 * <h3>New Reservation</h3>
	 * Ask for a date and make a new reservation
	 *
	 * @param loggedUser the user logged in
	 */
	private void newReservation (User loggedUser) {
		System.out.println("When do you want to make the reservation?");
		LocalDate date = this.askDate();
		if (reservationRepository.existsByUserAndReservationDate(loggedUser, date)) {
			System.out.println("You already have a reservation on this date!");
			this.newReservation(loggedUser);
		}
		this.newReservationMenu(loggedUser, date, null, null);
	}

	/**
	 * <h3>New Reservation Menu</h3>
	 *
	 * @param loggedUser the user logged in
	 * @param date       the date of the reservation
	 * @param type       the type of workstation
	 * @param city       the city of the building
	 */
	private void newReservationMenu (User loggedUser, LocalDate date, WorkstationType type, String city) {
		List<Workstation> workstations = this.getWorkstations(date, type, city);

		String tSelection = type == null
			? "Filter by type"
			: "Remove the filter by " + type;

		String cSelection = city == null
			? "Filter by city"
			: "Remove the filter by " + city;

		String workstationSelection = workstations.isEmpty()
			? "No workstation found."
			: this.getWorkstationsMenuString(workstations);

		System.out.printf("""
				Workstations available on %s:
				T. %s
				C. %s
				%s0. Back
				->\s""",
			date, tSelection, cSelection, workstationSelection
		);

		String selection = AppRunner.scan();

		switch (selection) {
			case "T" -> this.newReservationMenu(loggedUser, date, type == null ? this.askWorkstationType() : null, city);
			case "C" -> this.newReservationMenu(loggedUser, date, type, city == null ? this.askCity() : null);
			case "0" -> this.mainMenu(loggedUser);
			default -> {
				try {
					int intSelection = Integer.parseInt(selection);
					if (intSelection > 0 && intSelection <= workstations.size()) {
						Workstation workstation = workstations.get(intSelection - 1);
						reservationRepository.save(new Reservation(loggedUser, workstation, date));
						System.out.println("Reservation made successfully!");
						this.mainMenu(loggedUser);
					} else {
						System.out.println("Invalid selection!");
						this.newReservationMenu(loggedUser, date, type, city);
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid selection!");
					this.newReservationMenu(loggedUser, date, type, city);
				}
			}
		}
	}

	/**
	 * Get all workstations available on a date
	 *
	 * @param date the date of the reservation
	 * @param type the type of workstation
	 * @param city the city of the building
	 * @return list of workstations available
	 */
	private List<Workstation> getWorkstations (LocalDate date, WorkstationType type, String city) {
		if (type != null && city != null)
			return workstationRepository.findAllNotReservedOnDateAndTypeAndCity(date, type, city);
		else if (type != null) return workstationRepository.findAllNotReservedOnDateAndType(date, type);
		else if (city != null) return workstationRepository.findAllNotReservedOnDateAndCity(date, city);
		else return workstationRepository.findAllNotReservedOnDate(date);
	}

	/**
	 * Get a string with all workstations available
	 *
	 * @param workstations list of workstations
	 * @return string with all workstations available
	 */
	private @NotNull String getWorkstationsMenuString (@NotNull List<Workstation> workstations) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < workstations.size(); i++)
			sb.append(i + 1)
				.append(". ")
				.append(workstations.get(i).getDescription())
				.append(" (")
				.append(workstations.get(i).getBuilding().getName())
				.append(")\n");
		return sb.toString();
	}

	/**
	 * Ask for a workstation type
	 *
	 * @return workstation type
	 */
	private WorkstationType askWorkstationType () {
		System.out.println("Select a type:");
		for (int i = 0; i < WorkstationType.values().length; i++)
			System.out.println(i + 1 + ". " + WorkstationType.values()[i]);
		System.out.print("-> ");

		try {
			int selection = Integer.parseInt(AppRunner.scan());
			return WorkstationType.values()[selection - 1];
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("Invalid selection!");
			return this.askWorkstationType();
		}
	}

	/**
	 * Ask for a city. The list of cities is retrieved from the database
	 *
	 * @return city
	 */
	private @NotNull String askCity () {
		List<String> cities = buildingRepository.findDistinctCities();

		System.out.println("Select a city:");
		for (int i = 0; i < cities.size(); i++)
			System.out.println(i + 1 + ". " + cities.get(i));
		System.out.print("-> ");

		try {
			int selection = Integer.parseInt(AppRunner.scan());
			return cities.get(selection - 1);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("Invalid selection!");
			return this.askCity();
		}
	}

	/**
	 * Ask for a date until is valid
	 * A valid date is not empty and has a valid date format
	 *
	 * @return date
	 */
	private LocalDate askDate () {
		System.out.print("\tEnter the date (yyyy-mm-dd): ");
		String date = scan();
		try {
			return LocalDate.parse(date);
		} catch (DateTimeParseException _) {
			System.out.println("\tInvalid date format!");
			return this.askDate();
		}
	}

	/**
	 * <h3>My Reservations</h3>
	 * Print all reservations of the logged user ordered by date
	 *
	 * @param loggedUser the user logged in
	 */
	private void myReservations (User loggedUser) {
		List<Reservation> reservations = reservationRepository.findAllByUserOrderByReservationDateAsc(loggedUser);
		PrintHelper.printReservations(reservations.toArray(new Reservation[0]));
		this.mainMenu(loggedUser);
	}

}
