package Exercise3;

public class Customer {
	private final String fiscalCode;
	private String name;
	private String surname;
	private String email;
	private String regitrationDate;

	public Customer (String fiscalCode, String name, String surname, String email, String regitrationDate) {
		this.fiscalCode = fiscalCode;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.regitrationDate = regitrationDate;
	}

	@Override
	public String toString () {
		return "Customer{" +
			"name='" + this.name + '\'' +
			", surname='" + this.surname + '\'' +
			", fiscalCode='" + this.fiscalCode + '\'' +
			'}';
	}
}
