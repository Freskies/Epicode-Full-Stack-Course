package Media;

public class InvalidDurationException extends RuntimeException {
	public InvalidDurationException () {
		super("Duration must be a positive integer");
	}
}
