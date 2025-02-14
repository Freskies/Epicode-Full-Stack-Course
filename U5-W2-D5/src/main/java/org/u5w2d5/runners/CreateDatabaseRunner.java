package org.u5w2d5.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.u5w2d5.employee.Employee;
import org.u5w2d5.employee.EmployeeRepository;
import org.u5w2d5.travel.Travel;
import org.u5w2d5.travel.TravelRepository;
import org.u5w2d5.travel.TravelState;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CreateDatabaseRunner implements CommandLineRunner {
	private final EmployeeRepository employeeRepository;
	private final TravelRepository travelRepository;

	@Override
	public void run (String... args) throws Exception {
		Employee[] employees = new Employee[] {
			new Employee("jd258", "John", "Doe", "jd@example.com"),
			new Employee("md123", "Mary", "Doe", "md@example.com"),
			new Employee("sb456", "Sam", "Brown", "sb@example.com"),
			new Employee("lk789", "Linda", "King", "lk@example.com"),
			new Employee("rw321", "Robert", "White", "rw@example.com"),
			new Employee("am654", "Alice", "Miller", "am@example.com"),
			new Employee("jt987", "James", "Taylor", "jt@example.com"),
			new Employee("kp432", "Karen", "Parker", "kp@example.com"),
			new Employee("gh876", "George", "Harris", "gh@example.com"),
			new Employee("bw543", "Betty", "Wilson", "bw@example.com")
		};

		this.employeeRepository.saveAll(Arrays.asList(employees));

		Travel[] travels = new Travel[] {
			new Travel("Paris", LocalDate.of(2006, 5, 12), TravelState.FINISHED),
			new Travel("London", LocalDate.of(2007, 6, 23), TravelState.FINISHED),
			new Travel("New York", LocalDate.of(2008, 7, 14), TravelState.FINISHED),
			new Travel("Tokyo", LocalDate.of(2009, 8, 25), TravelState.FINISHED),
			new Travel("Berlin", LocalDate.of(2010, 9, 16), TravelState.FINISHED),
			new Travel("Rome", LocalDate.of(2011, 10, 27), TravelState.FINISHED),
			new Travel("Madrid", LocalDate.of(2012, 11, 18), TravelState.FINISHED),
			new Travel("Moscow", LocalDate.of(2013, 12, 29), TravelState.FINISHED),
			new Travel("Beijing", LocalDate.of(2014, 1, 10), TravelState.FINISHED),
			new Travel("Cairo", LocalDate.of(2026, 2, 21), TravelState.PLANNED),
			new Travel("Sydney", LocalDate.of(2027, 3, 3), TravelState.PLANNED),
		};

		this.travelRepository.saveAll(Arrays.asList(travels));
	}
}
