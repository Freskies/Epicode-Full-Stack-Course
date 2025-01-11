package Media;

/**
 * Abstract class representing an audio media that can be played.
 */
public abstract class Audio extends PlayableMedia implements Volume {
	private int volume = Volume.DEFAULT_VOLUME;
	protected int stepVolume = Volume.DEFAULT_STEP_VOLUME;

	/**
	 * Constructs an Audio object with the specified title and duration.
	 *
	 * @param title           the title of the audio
	 * @param durationSeconds the duration of the audio in seconds
	 */
	protected Audio (String title, int durationSeconds) {
		super(title, durationSeconds);
	}

	// VOLUME

	/**
	 * Sets the volume of the media.
	 * If the volume is not between MIN_VOLUME and MAX_VOLUME an InvalidVolumeException is thrown.
	 *
	 * @param volume the volume of the media
	 * @throws InvalidVolumeException if the volume is not between MIN_VOLUME and MAX_VOLUME
	 */
	protected void setVolume (int volume) {
		if (Volume.isInvalidVolume(volume))
			throw new InvalidVolumeException(Volume.getErrorVolumeMessage(volume));
		this.volume = volume;
	}

	@Override
	public int getVolume () {
		return this.volume;
	}

	@Override
	public void increaseVolume () {
		try {
			this.setVolume(this.volume + this.stepVolume);
		} catch (InvalidVolumeException e) {
			this.setVolume(Volume.MAX_VOLUME);
		}
	}

	@Override
	public void decreaseVolume () {
		try {
			this.setVolume(this.volume - this.stepVolume);
		} catch (InvalidVolumeException e) {
			this.setVolume(Volume.MIN_VOLUME);
		}
	}

	// PLAYABLE MEDIA

	/**
	 * Plays the audio by printing the title and the volume of the audio at each second.
	 * The volume is represented by the number of exclamation marks following the title.
	 */
	@Override
	public void play () {
		for (int i = 0; i < this.durationSeconds; i++)
			System.out.printf(
				"%s -> %s%s\n",
				Duration.getDurationString(i),
				this.title,
				"!".repeat(this.getVolume())
			);
	}
}
