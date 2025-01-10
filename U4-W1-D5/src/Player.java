import Media.Media;
import Media.ShowableMedia;
import Media.PlayableMedia;
import Media.Image;
import Media.Audio;
import Media.Video;

import java.util.Arrays;

public class Player {
	public static final int MEDIA_REQUIRED = 2;

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

	/**
	 * Get the list of media.
	 *
	 * @return List of media.
	 */
	public String getMediaList () {
		StringBuilder mediaListString = new StringBuilder("\n");
		for (int i = 0; i < this.mediaList.length; i++)
			mediaListString
				.append(i + 1)
				.append(". ")
				.append(this.mediaList[i].getTitle())
				.append("\n");
		return mediaListString.toString();
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
		if (this.mediaList[index] instanceof ShowableMedia)
			((ShowableMedia) mediaList[index]).show();
		else if (this.mediaList[index] instanceof PlayableMedia)
			((PlayableMedia) mediaList[index]).play();
		else
			System.out.println("Media type not supported.");
	}

	/**
	 * Get the actions of the media at index.
	 * If media is Image, return 2 actions to increase and decrease brightness.
	 * If media is Audio, return 2 actions to increase and decrease volume.
	 * If media is Video, return 4 actions to increase and decrease brightness and volume.
	 * If media is null, return 0 actions with message "Media does not support actions."
	 *
	 * @param index Index of media to get actions.
	 * @return Actions of the media at index.
	 * @throws ArrayIndexOutOfBoundsException If index is out of bounds.
	 */
	public PlayerActions getActionsOfMedia (int index) {
		return switch (this.mediaList[index]) {
			case Image _ -> new PlayerActions(2, """
				1. Increase brightness
				2. Decrease brightness"""
			);
			case Audio _ -> new PlayerActions(2, """
				1. Increase volume
				2. Decrease volume"""
			);
			case Video _ -> new PlayerActions(4, """
				1. Increase brightness
				2. Decrease brightness
				3. Increase volume
				4. Decrease volume"""
			);
			case null, default -> new PlayerActions(0, "Media does not support actions.");
		};
	}

	@Override
	public String toString () {
		return "Player{" +
			"mediaList=" + Arrays.toString(mediaList) +
			'}';
	}
}
