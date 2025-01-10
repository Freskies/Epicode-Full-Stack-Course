package Media;

/**
 * Abstract class representing an image media that can be shown.
 */
public abstract class Image extends ShowableMedia {

	/**
	 * Constructs an Image object with the specified title.
	 *
	 * @param title the title of the image
	 */
	protected Image (String title) {
		super(title);
	}

	/**
	 * Shows the image by printing the title followed by a number of asterisks
	 * equal to the brightness of the image.
	 */
	@Override
	public void show () {
		System.out.println(this.title + "*".repeat(this.getBrightness()));
	}
}
