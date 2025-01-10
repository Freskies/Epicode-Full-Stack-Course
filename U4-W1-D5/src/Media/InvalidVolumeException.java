package Media;

public class InvalidVolumeException extends RuntimeException {
	public InvalidVolumeException (String message) {
		super(message.isEmpty() ? "Invalid volume" : message);
	}
}
