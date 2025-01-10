package Media;

public interface Duration {

	/**
	 * Checks if the duration is valid.
	 * A duration is valid if it is greater than 0.
	 *
	 * @param duration The duration to check.
	 * @return true if the duration is valid, false otherwise.
	 */
	static boolean isValidDuration (int duration) {
		return duration > 0;
	}

	/**
	 * Returns a formatted string of the duration in the format "mm:ss".
	 *
	 * @param durationSeconds The duration in seconds.
	 * @return the formatted string of the duration
	 */
	static String getDurationString (int durationSeconds) {
		int minutes = Math.floorDiv(durationSeconds, 60);
		int seconds = durationSeconds % 60;
		return "%02d:%02d".formatted(minutes, seconds);
	}
}
