import Media.Media;
import Media.Image;
import Media.Audio;
import Media.Video;
import MyMedia.MP3;
import MyMedia.MP4;
import MyMedia.PNG;

import java.util.Scanner;

public class Main {
	private static final String LOAD_MENU = """
		#############
		1. Load PNG
		2. Load MP3
		3. Load MP4
		0. Exit
		->\s""";

	private static final String PLAYER_MENU = """
		#############
		1. Open media
		2. Modify media
		0. Exit
		->\s""";

	private static final Scanner scanner = new Scanner(System.in);

	private static String scan () {
		return Main.scanner.nextLine();
	}

	public static void main (String[] args) {
		Player player = Main.generatePlayer();
		if (player == null) return;
		System.out.println("Player created.");

		Main.playPlayer(player);
	}

	// GENERATE PLAYER

	private static Player generatePlayer () {
		Media[] mediaList = new Media[Player.MEDIA_REQUIRED];

		for (int i = 0; i < mediaList.length; i++) {
			mediaList[i] = Main.loadMedia();
			if (mediaList[i] == null)
				return null;
			System.out.printf("Media %d loaded, %d remaining\n", i + 1, mediaList.length - i - 1);
		}

		return new Player(mediaList);
	}

	private static Media loadMedia () {
		String input;
		System.out.print(Main.LOAD_MENU);
		input = Main.scan();

		return switch (input) {
			case "0" -> null;
			case "1" -> Main.askPNG();
			case "2" -> Main.askMP3();
			case "3" -> Main.askMP4();
			default -> {
				System.out.println("Invalid input.");
				yield Main.loadMedia();
			}
		};
	}

	private static PNG askPNG () {
		String title = Main.askTitle();
		return new PNG(title);
	}

	private static MP3 askMP3 () {
		String title = Main.askTitle();
		int duration = Main.askDuration();
		return new MP3(title, duration);
	}

	private static MP4 askMP4 () {
		String title = Main.askTitle();
		int duration = Main.askDuration();
		return new MP4(title, duration);
	}

	private static String askTitle () {
		System.out.print("Enter title: ");
		String title = Main.scan();
		if (!title.isEmpty())
			return title;
		System.out.println("Title cannot be empty.");
		return Main.askTitle();
	}

	private static int askDuration () {
		try {
			System.out.print("Enter duration: ");
			String input = Main.scan();
			int duration = Integer.parseInt(input);
			if (duration > 0)
				return duration;
			System.out.println("Duration cannot be less than or equal to 0.");
		} catch (NumberFormatException e) {
			System.out.println("Duration must be a number.");
		}
		return Main.askDuration();
	}

	// PLAY PLAYER

	private static void playPlayer (Player player) {
		System.out.print(Main.PLAYER_MENU);
		String input = Main.scan();

		switch (input) {
			case "0" -> {
				return;
			}
			case "1" -> Main.openMedia(player, Main.selectMedia(player));
			case "2" -> Main.modifyMedia(player, Main.selectMedia(player));
			default -> System.out.println("Invalid input!");
		}
		Main.playPlayer(player);
	}

	private static void openMedia (Player player, int index) {
		if (index == -1) return;
		player.openMedia(index);
	}

	private static void modifyMedia (Player player, int index) {
		if (index == -1) return;
		PlayerActions actions = Main.generatePlayerActions(player.getMedia(index));

		System.out.print(Main.generateMediaActionMenu(actions));
		String input = Main.scan();

		if (input.equals("0")) return;

		try {
			int action = Integer.parseInt(input);
			if (actions.isValidAction(action)) {
				Main.doAction(player.getMedia(index), action);
				Main.modifyMedia(player, index);
			}
		} catch (NumberFormatException ignored) {
			System.out.println("Invalid action!");
			Main.modifyMedia(player, index);
		}
	}

	private static int selectMedia (Player player) {
		System.out.print(Main.generateSelectMediaMenu(player.getMediaList()));
		String input = Main.scan();

		if (input.equals("0"))
			return -1;

		try {
			int index = Integer.parseInt(input);
			player.getMedia(index - 1);
			return index - 1;
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException ignored) {
		}

		System.out.println("Invalid selection!");
		return Main.selectMedia(player);
	}

	private static String generateSelectMediaMenu (Media[] mediaList) {
		StringBuilder mediaListString = new StringBuilder("--------------\n");
		for (int i = 0; i < mediaList.length; i++)
			mediaListString
				.append(i + 1)
				.append(". ")
				.append(mediaList[i].getTitle())
				.append("\n");
		mediaListString.append("0. Back\n-> ");
		return mediaListString.toString();
	}

	private static PlayerActions generatePlayerActions (Media media) {
		return switch (media) {
			case Image _ -> new PlayerActions(2, """
				1. Increase brightness
				2. Decrease brightness
				0. Exit"""
			);
			case Audio _ -> new PlayerActions(2, """
				1. Increase volume
				2. Decrease volume
				0. Exit"""
			);
			case Video _ -> new PlayerActions(4, """
				1. Increase brightness
				2. Decrease brightness
				3. Increase volume
				4. Decrease volume
				0. Exit"""
			);
			case null, default -> new PlayerActions(0, """
				Media does not support actions.
				0. Exit""");
		};
	}

	private static String generateMediaActionMenu (PlayerActions mediaAction) {
		return "~~~~~~~~~~~~~~\n%s\n-> ".formatted(mediaAction);
	}

	private static void doAction (Media media, int action) {
		switch (media) {
			case PNG png -> Main.doPNGAction(png, action);
			case MP3 mp3 -> Main.doMP3Action(mp3, action);
			case MP4 mp4 -> Main.doMP4Action(mp4, action);
			case null, default -> System.out.println("Media type not supported.");
		}
	}

	private static void doPNGAction (PNG png, int action) {
		switch (action) {
			case 1 -> {
				int preBrightness = png.getBrightness();
				png.increaseBrightness();
				System.out.printf("Brightness increased (%d -> %d).\n", preBrightness, png.getBrightness());
			}
			case 2 -> {
				int preBrightness = png.getBrightness();
				png.decreaseBrightness();
				System.out.printf("Brightness decreased (%d -> %d).\n", preBrightness, png.getBrightness());
			}
		}
	}

	private static void doMP3Action (MP3 mp3, int action) {
		switch (action) {
			case 1 -> {
				int preVolume = mp3.getVolume();
				mp3.increaseVolume();
				System.out.printf("Volume increased (%d -> %d).\n", preVolume, mp3.getVolume());
			}
			case 2 -> {
				int preVolume = mp3.getVolume();
				mp3.decreaseVolume();
				System.out.printf("Volume decreased (%d -> %d).\n", preVolume, mp3.getVolume());
			}
		}
	}

	private static void doMP4Action (MP4 mp4, int action) {
		switch (action) {
			case 1 -> {
				int preBrightness = mp4.getBrightness();
				mp4.increaseBrightness();
				System.out.printf("Brightness increased (%d -> %d).\n", preBrightness, mp4.getBrightness());
			}
			case 2 -> {
				int preBrightness = mp4.getBrightness();
				mp4.decreaseBrightness();
				System.out.printf("Brightness decreased (%d -> %d).\n", preBrightness, mp4.getBrightness());
			}
			case 3 -> {
				int preVolume = mp4.getVolume();
				mp4.increaseVolume();
				System.out.printf("Volume increased (%d -> %d).\n", preVolume, mp4.getVolume());
			}
			case 4 -> {
				int preVolume = mp4.getVolume();
				mp4.decreaseVolume();
				System.out.printf("Volume decreased (%d -> %d).\n", preVolume, mp4.getVolume());
			}
		}
	}
}