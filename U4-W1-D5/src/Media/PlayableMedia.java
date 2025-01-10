package Media;

/**
 * Abstract class representing a media that can be played.
 */
public abstract class PlayableMedia extends Media implements Volume, Duration {
	public final int durationSeconds;

	private int volume = Volume.DEFAULT_VOLUME;
	protected int stepVolume = Volume.DEFAULT_STEP_VOLUME;

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

	/**
	 * Sets the volume of the media.
	 * If the volume is not between MIN_VOLUME and MAX_VOLUME an InvalidVolumeException is thrown.
	 *
	 * @param volume the volume of the media
	 * @throws InvalidVolumeException if the volume is not between MIN_VOLUME and MAX_VOLUME
	 */
	protected void setVolume (int volume) {
		if (!Volume.isValidVolume(volume))
			throw new InvalidVolumeException(Volume.getErrorVolumeMessage(volume));
		this.volume = volume;
	}

	// VOLUME METHODS

	@Override
	public int getVolume () {
		return this.volume;
	}

	@Override
	public void increaseVolume () {
		try {
			this.setVolume(this.volume + this.stepVolume);
		} catch (InvalidBrightnessException e) {
			this.setVolume(Volume.MAX_VOLUME);
		}
	}

	@Override
	public void decreaseVolume () {
		try {
			this.setVolume(this.volume - this.stepVolume);
		} catch (InvalidBrightnessException e) {
			this.setVolume(Volume.MIN_VOLUME);
		}
	}

	// ABSTRACT METHODS

	public abstract void play ();
}
