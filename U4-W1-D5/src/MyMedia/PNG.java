package MyMedia;

import Media.Image;

/**
 * PNG class that extends Image (showable media).
 */
public class PNG extends Image {

	/**
	 * Constructor for PNG.
	 *
	 * @param title Title of the PNG.
	 */
	public PNG (String title) {
		super(title);
	}

	@Override
	public String toString () {
		return "PNG{title='%s',brightness=%d}".formatted(this.title, this.getBrightness());
	}
}
