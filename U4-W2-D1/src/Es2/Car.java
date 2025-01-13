package Es2;

public class Car {
	public double km;
	public double gas;

	public Car (double km, double gas) {
		if (gas == 0) throw new IllegalArgumentException("A car must have gas");
		this.km = km;
		this.gas = gas;
	}

	public double calc() {
		return this.km / this.gas;
	}
}
