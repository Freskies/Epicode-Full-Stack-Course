package MyMedia;

import Media.Audio;

public class MP3 extends Audio {

	public MP3 (String title, int durationSeconds) {
		super(title, durationSeconds);
	}

	@Override
	public String toString () {
		return "MP3{title='%s',volume=%d}".formatted(this.title, this.getVolume());
	}
}
