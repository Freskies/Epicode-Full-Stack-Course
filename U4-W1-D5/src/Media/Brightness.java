package Media;

/**
 * Interface representing the brightness of a media.
 */
public interface Brightness {
	int MIN_BRIGHTNESS = 1;
	int MAX_BRIGHTNESS = 10;

	int DEFAULT_BRIGHTNESS = 5;
	int DEFAULT_STEP_BRIGHTNESS = 1;

	/**
	 * Returns the brightness of the media.
	 */
	int getBrightness ();

	/**
	 * Add the step brightness to the current brightness.
	 * If the brightness is greater than MAX_BRIGHTNESS, the brightness is set to MAX_BRIGHTNESS.
	 */
	void increaseBrightness ();

	/**
	 * Subtract the step brightness to the current brightness.
	 * If the brightness is less than MIN_BRIGHTNESS, the brightness is set to MIN_BRIGHTNESS.
	 */
	void decreaseBrightness ();

	/**
	 * Checks if the brightness is invalid.
	 * A brightness is valid if it is between MIN_BRIGHTNESS and MAX_BRIGHTNESS.
	 *
	 * @param brightness The brightness to check.
	 * @return true if the brightness is invalid, false otherwise.
	 */
	static boolean isInvalidBrightness (int brightness) {
		return Brightness.MIN_BRIGHTNESS > brightness || brightness > Brightness.MAX_BRIGHTNESS;
	}

	/**
	 * Returns an error message for an invalid brightness.
	 *
	 * @param brightness The brightness that is invalid.
	 * @return An error message for an invalid brightness.
	 */
	static String getErrorBrightnessMessage (int brightness) {
		return "Brightness must be between %d and %d but got %d".formatted(
			Brightness.MIN_BRIGHTNESS, Brightness.MAX_BRIGHTNESS, brightness
		);
	}
}
