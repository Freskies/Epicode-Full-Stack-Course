package Exercise2;

public record Call(String name, int seconds) {
	public double getFee () {
		return this.seconds * 0.2;
	}

	@Override
	public String toString () {
		return this.name;
	}
}
