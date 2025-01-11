import Media.Media;
import Media.ShowableMedia;
import Media.PlayableMedia;

import java.util.Arrays;

public class Player {
	public static final int MEDIA_REQUIRED = 5;

	private final Media[] mediaList = new Media[Player.MEDIA_REQUIRED];

	/**
	 * Constructor for Player class.
	 * Requires at least MEDIA_REQUIRED media to play.
	 * If less than MEDIA_REQUIRED media is provided, an IllegalArgumentException is thrown.
	 *
	 * @param mediaList List of media to play.
	 * @throws IllegalArgumentException If mediaList is less than MEDIA_REQUIRED.
	 */
	public Player (Media... mediaList) {
		if (mediaList.length < Player.MEDIA_REQUIRED)
			throw new IllegalArgumentException("Not enough media to play.");
		System.arraycopy(mediaList, 0, this.mediaList, 0, Player.MEDIA_REQUIRED);
	}

	public Media[] getMediaList () {
		return this.mediaList;
	}

	public Media getMedia (int index) {
		return this.mediaList[index];
	}

	/**
	 * Open media at index.
	 * If media is ShowableMedia, show it.
	 * If media is PlayableMedia, play it.
	 * If media is neither, print "Media type not supported."
	 *
	 * @param index Index of media to open.
	 * @throws ArrayIndexOutOfBoundsException If index is out of bounds.
	 */
	public void openMedia (int index) {
		switch (this.mediaList[index]) {
			case ShowableMedia showable -> showable.show();
			case PlayableMedia playable -> playable.play();
			default -> System.out.println("Media type not supported.");
		}
	}

	@Override
	public String toString () {
		return "Player{" +
			"mediaList=" + Arrays.toString(mediaList) +
			'}';
	}
}
