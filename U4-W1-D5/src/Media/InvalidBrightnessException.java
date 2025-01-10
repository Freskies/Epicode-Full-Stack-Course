package Media;

public class InvalidBrightnessException extends RuntimeException {
	public InvalidBrightnessException (String message) {
		super(message.isEmpty() ? "Invalid brightness" : message);
	}
}
