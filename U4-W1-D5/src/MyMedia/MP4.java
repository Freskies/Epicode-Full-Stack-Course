package MyMedia;

import Media.Video;

/**
 * MP4 class that extends Video (playable media).
 */
public class MP4 extends Video {

	/**
	 * Constructor for MP4.
	 *
	 * @param title           Title of the MP4.
	 * @param durationSeconds Duration of the MP4 in seconds.
	 */
	public MP4 (String title, int durationSeconds) {
		super(title, durationSeconds);
	}

	@Override
	public String toString () {
		return "MP4{title='%s',volume=%d,brightness=%d}".formatted(this.title, this.getVolume(), this.getBrightness());
	}
}
