public class PartTimeEmployee extends Employee {
	private double hoursWorked;
	private double salaryPerHours;
	private String checkInTime;

	public PartTimeEmployee (
		String registrationNoun,
		Department department,
		double hoursWorked,
		double salaryPerHours,
		String checkInTime
	) {
		super(registrationNoun, department);
		this.hoursWorked = hoursWorked;
		this.salaryPerHours = salaryPerHours;
		this.checkInTime = checkInTime;
	}

	public double getHoursWorked () {
		return this.hoursWorked;
	}

	public void setHoursWorked (double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getSalaryPerHours () {
		return this.salaryPerHours;
	}

	public void setSalaryPerHours (double salaryPerHours) {
		this.salaryPerHours = salaryPerHours;
	}

	public String getCheckInTime () {
		return this.checkInTime;
	}

	public void setCheckInTime (String checkInTime) {
		this.checkInTime = checkInTime;
	}

	@Override
	public double calculateSalary () {
		return this.hoursWorked * this.salaryPerHours;
	}

	@Override
	public String checkIn () {
		return this.checkInTime;
	}
}
