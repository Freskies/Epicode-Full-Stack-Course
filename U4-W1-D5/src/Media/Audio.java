package Media;

/**
 * Abstract class representing an audio media that can be played.
 */
public abstract class Audio extends PlayableMedia {

	/**
	 * Constructs an Audio object with the specified title and duration.
	 *
	 * @param title           the title of the audio
	 * @param durationSeconds the duration of the audio in seconds
	 */
	protected Audio (String title, int durationSeconds) {
		super(title, durationSeconds);
	}

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
