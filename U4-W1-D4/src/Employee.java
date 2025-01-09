public abstract class Employee implements Worker {
	private final String registrationNoun;
	private Department department;

	public Employee (String registrationNoun, Department department) {
		this.registrationNoun = registrationNoun;
		this.department = department;
	}

	// GETTERS

	public String getRegistrationNoun () {
		return this.registrationNoun;
	}

	public Department getDepartment () {
		return this.department;
	}

	// SETTERS

	public void setDepartment (Department department) {
		this.department = department;
	}

	// PUBLIC INTERFACE

	public abstract double calculateSalary ();

	@Override
	public String toString () {
		return "Employee{" +
			"registrationNoun='" + this.registrationNoun + '\'' +
			", department=" + this.department +
			'}';
	}
}
