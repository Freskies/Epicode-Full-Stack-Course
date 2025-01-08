package Exercise2;

import java.util.Arrays;

public class Sim {
	private final String phoneNumber;
	private double credit;
	private String[] last5Calls = {"", "", "", "", ""};

	public Sim (String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.credit = 0;
	}

	public Sim (String phoneNumber, double credit) {
		this.phoneNumber = phoneNumber;
		this.credit = credit;
	}

	public Sim call (String contactCalled) {
		this.last5Calls = new String[] {
			contactCalled,
			this.last5Calls[0],
			this.last5Calls[1],
			this.last5Calls[2],
			this.last5Calls[3]
		};
		return this;
	}

	public Sim charge (double fee) {
		this.credit += fee;
		return this;
	}

	@Override
	public String toString () {
		return "Sim{" +
			"phoneNumber='" + phoneNumber + '\'' +
			", credit=" + credit +
			", last5Calls=" + Arrays.toString(last5Calls) +
			'}';
	}

	public static void main (String[] argv) {
		Sim sim = new Sim("0812345678", 100);
		sim.charge(50).call("Ryan").call("Marcelo");
		System.out.println(sim);
	}
}
