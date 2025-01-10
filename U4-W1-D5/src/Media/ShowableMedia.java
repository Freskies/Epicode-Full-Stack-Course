package Media;

/**
 * Abstract class representing a media that can be shown.
 */
public abstract class ShowableMedia extends Media implements Brightness {
	private int brightness = Brightness.DEFAULT_BRIGHTNESS;
	protected int stepBrightness = Brightness.DEFAULT_STEP_BRIGHTNESS;

	/**
	 * Constructs a ShowableMedia object with the specified title.
	 *
	 * @param title the title of the media
	 */
	protected ShowableMedia (String title) {
		super(title);
	}

	/**
	 * Sets the brightness of the media.
	 * If the brightness is not between MIN_BRIGHTNESS and MAX_BRIGHTNESS an InvalidBrightnessException is thrown.
	 *
	 * @param brightness the brightness of the media
	 * @throws InvalidBrightnessException if the brightness is not between MIN_BRIGHTNESS and MAX_BRIGHTNESS
	 */
	protected void setBrightness (int brightness) {
		if (Brightness.isInvalidBrightness(brightness))
			throw new InvalidBrightnessException(Brightness.getErrorBrightnessMessage(brightness));
		this.brightness = brightness;
	}

	// BRIGHTNESS METHODS

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

	// ABSTRACT METHODS

	public abstract void show ();
}
