public class Main {
	public static void main (String[] args) {
		System.out.println("--- EMPLOYEE ---");
		Employee[] employees = new Employee[] {
			new FullTimeEmployee("John Doe", Department.PRODUCTION, 1000),
			new PartTimeEmployee("Ryan Bean", Department.SALES, 40, 25, "1:00 PM"),
			new Manager("Marcelo Moe", Department.ADMINISTRATION, 2000)
		};

		for (Employee employee : employees)
			System.out.printf("%s -> %.2f€\n", employee, employee.calculateSalary());

		System.out.println("--- WORKERS ---");
		Worker[] workers = {
			new FullTimeEmployee("John Doe", Department.PRODUCTION, 1000),
			new PartTimeEmployee("Ryan Bean", Department.SALES, 40, 25, "1:00 PM"),
			new Manager("Marcelo Moe", Department.ADMINISTRATION, 2000),
			new Voluntary("Orlando Bloom", "30", "Singer"),
			new Voluntary("Johnny Depp", "40", "Cake Baker")
		};

		for (Worker worker : workers)
			System.out.printf("%s -> %s\n", worker, worker.checkIn());
	}
}