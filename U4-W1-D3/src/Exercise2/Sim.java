package Exercise2;

import java.util.Arrays;

public class Sim {
	private final String phoneNumber;
	private double credit;
	private Call[] last5Calls = new Call[5];

	public Sim (String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.credit = 0;
	}

	public Sim (String phoneNumber, double credit) {
		this.phoneNumber = phoneNumber;
		this.credit = credit;
	}

	public Sim call (Call call) {
		this.last5Calls = new Call[] {
			call,
			this.last5Calls[0],
			this.last5Calls[1],
			this.last5Calls[2],
			this.last5Calls[3]
		};
		this.credit -= call.getFee();
		return this;
	}

	public Sim charge (double fee) {
		this.credit += fee;
		return this;
	}

	@Override
	public String toString () {
		return "Sim{" +
			"phoneNumber='" + this.phoneNumber + '\'' +
			", credit=" + "%.2f".formatted(this.credit) + "€" +
			", last5Calls=" + Arrays.toString(this.last5Calls) +
			'}';
	}

	public static void main (String[] argv) {
		Sim sim = new Sim("0812345678", 100);
		sim
			.charge(50)
			.call(new Call("Ryan", 18))
			.call(new Call("Marcelo", 180))
			.call(new Call("Orlando", 200))
			.call(new Call("John", 10))
			.call(new Call("Liam", 34))
			.call(new Call("Arthur", 180));

		System.out.println(sim);
	}
}
