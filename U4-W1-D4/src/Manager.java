public class Manager extends Employee {
	private double salary;

	public Manager (String registrationNoun, Department department, double salary) {
		super(registrationNoun, department);
		this.salary = salary;
	}

	public double getSalary () {
		return this.salary;
	}

	public void setSalary (double salary) {
		this.salary = salary;
	}

	@Override
	public double calculateSalary () {
		return this.salary;
	}

	@Override
	public String checkIn () {
		return "Undefined";
	}
}
