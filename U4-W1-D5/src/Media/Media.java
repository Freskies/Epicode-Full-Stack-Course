package Media;

/**
 * Represents a media object.
 */
public abstract class Media {
	protected final String title;

	/**
	 * Creates a new media object.
	 *
	 * @param title The title of the media.
	 */
	protected Media (String title) {
		this.title = title;
	}

	/**
	 * Gets the title of the media.
	 */
	public String getTitle () {
		return this.title;
	}
}
