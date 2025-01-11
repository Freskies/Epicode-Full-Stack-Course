package Media;

/**
 * Abstract class representing a video media that can be played.
 */
public abstract class Video extends PlayableMedia implements Brightness, Volume {
	private int brightness = Brightness.DEFAULT_BRIGHTNESS;
	protected int stepBrightness = Brightness.DEFAULT_STEP_BRIGHTNESS;

	private int volume = Volume.DEFAULT_VOLUME;
	protected int stepVolume = Volume.DEFAULT_STEP_VOLUME;

	/**
	 * Constructs a Video object with the specified title and duration.
	 *
	 * @param title           the title of the video
	 * @param durationSeconds the duration of the video in seconds
	 */
	protected Video (String title, int durationSeconds) {
		super(title, durationSeconds);
	}

	// BRIGHTNESS

	/**
	 * Sets the brightness of the video.
	 * If the brightness is not between MIN_BRIGHTNESS and MAX_BRIGHTNESS,
	 * an InvalidBrightnessException is thrown.
	 *
	 * @param brightness the brightness of the video
	 * @throws InvalidBrightnessException if the brightness is not between MIN_BRIGHTNESS and MAX_BRIGHTNESS
	 */
	protected void setBrightness (int brightness) {
		if (Brightness.isInvalidBrightness(brightness))
			throw new InvalidBrightnessException(Brightness.getErrorBrightnessMessage(brightness));
		this.brightness = brightness;
	}

	@Override
	public int getBrightness () {
		return this.brightness;
	}

	@Override
	public void increaseBrightness () {
		try {
			this.setBrightness(this.brightness + this.stepBrightness);
		} catch (InvalidBrightnessException e) {
			this.setBrightness(Brightness.MAX_BRIGHTNESS);
		}
	}

	@Override
	public void decreaseBrightness () {
		try {
			this.setBrightness(this.brightness - this.stepBrightness);
		} catch (InvalidBrightnessException e) {
			this.setBrightness(Brightness.MIN_BRIGHTNESS);
		}
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
	 * Plays the video by printing the title, the volume, and the brightness of the video at each second.
	 * The volume is represented by the number of exclamation marks following the title.
	 * The brightness is represented by the number of asterisks following the volume.
	 */
	@Override
	public void play () {
		for (int i = 0; i < this.durationSeconds; i++)
			System.out.printf(
				"%s -> %s%s%s\n",
				Duration.getDurationString(i),
				this.title,
				"!".repeat(this.getVolume()),
				"*".repeat(this.getBrightness())
			);
	}
}
