package Media;

/**
 * Abstract class representing a media that can be played.
 */
public abstract class PlayableMedia extends Media implements Duration {
	public final int durationSeconds;

	/**
	 * Constructs a PlayableMedia object with the specified title and duration.
	 * If the duration is less than or equal to 0 an InvalidDurationException is thrown.
	 *
	 * @param title           the title of the media
	 * @param durationSeconds the duration of the media in seconds
	 * @throws InvalidDurationException if the duration is less than or equal to 0
	 */
	protected PlayableMedia (String title, int durationSeconds) {
		super(title);
		if (!Duration.isValidDuration(durationSeconds))
			throw new InvalidDurationException();
		this.durationSeconds = durationSeconds;
	}

	// ABSTRACT METHODS

	public abstract void play ();
}
