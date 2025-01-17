package Library;

public enum Periodicity {
	WEEKLY,
	MONTHLY,
	SEMIANNUAL;

	@Override
	public String toString () {
		return switch (this) {
			case WEEKLY -> "Weekly";
			case MONTHLY -> "Monthly";
			case SEMIANNUAL -> "Semiannual";
		};
	}
}
