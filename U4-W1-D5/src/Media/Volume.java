package Media;

/**
 * Interface representing the volume of a media.
 */
public interface Volume {
	int MIN_VOLUME = 0;
	int MAX_VOLUME = 10;

	int DEFAULT_VOLUME = 7;
	int DEFAULT_STEP_VOLUME = 1;

	/**
	 * Returns the volume of the media.
	 */
	int getVolume ();

	/**
	 * Add the step volume to the current volume.
	 * If the volume is greater than MAX_VOLUME, the volume is set to MAX_VOLUME.
	 */
	void increaseVolume ();

	/**
	 * Subtract the step volume to the current volume.
	 * If the volume is less than MIN_VOLUME, the volume is set to MIN_VOLUME.
	 */
	void decreaseVolume ();

	/**
	 * Checks if the volume is valid.
	 * A volume is valid if it is between MIN_VOLUME and MAX_VOLUME.
	 *
	 * @param volume The volume to check.
	 * @return true if the volume is valid, false otherwise.
	 */
	static boolean isValidVolume (int volume) {
		return Volume.MIN_VOLUME <= volume && volume <= Volume.MAX_VOLUME;
	}

	/**
	 * Returns an error message for an invalid volume.
	 *
	 * @param volume The invalid volume.
	 * @return an error message for an invalid volume.
	 */
	static String getErrorVolumeMessage (int volume) {
		return "Volume must be between %d and %d but got %d".formatted(
			Volume.MIN_VOLUME, Volume.MAX_VOLUME, volume
		);
	}
}
