import Media.Media;
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
		String input;

		System.out.print(Main.PLAYER_MENU);
		input = Main.scanner.nextLine();

		/*
		while (!input.equals("0")) {
			System.out.print(Main.PLAYER_MENU);
			input = scanner.nextLine();

			switch (input) {
				case "1":
					while (true) {
						System.out.print("--------------");
						System.out.print(player.getMediaList());
						System.out.println("0. Back");
						System.out.print("-> ");
						try {
							int mediaIndex = Integer.parseInt(scanner.nextLine());
							if (mediaIndex == 0)
								break;
							if (mediaIndex < 1 || mediaIndex > Player.MEDIA_REQUIRED) {
								System.out.println("Invalid index.");
								continue;
							}
							player.openMedia(mediaIndex - 1);
							break;
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Index out of bounds.");
						} catch (NumberFormatException e) {
							System.out.println("Index must be a number.");
						}
					}
					break;
				case "2":
					while (true) {
						System.out.print("--------------");
						System.out.print(player.getMediaList());
						System.out.println("0. Back");
						System.out.print("-> ");
						try {
							int mediaIndex = Integer.parseInt(scanner.nextLine());
							if (mediaIndex == 0)
								break;
							if (mediaIndex < 1 || mediaIndex > Player.MEDIA_REQUIRED) {
								System.out.println("Invalid index.");
								continue;
							}
							PlayerActions actions = player.getActionsOfMedia(mediaIndex - 1);
							while (true) {
								System.out.println("--------------");
								System.out.println(actions);
								System.out.println("0. Back");
								System.out.print("-> ");
								try {
									int actionIndex = Integer.parseInt(scanner.nextLine());
									if (actionIndex == 0)
										break;
									if (actionIndex < 1 || actionIndex > actions.getNumberOfActions()) {
										System.out.println("Invalid index.");
										continue;
									}
									switch (mediaList[mediaIndex - 1]) {
										case PNG png -> {
											switch (actionIndex) {
												case 1 -> {
													png.increaseBrightness();
													System.out.println("Brightness increased.");
												}
												case 2 -> {
													png.decreaseBrightness();
													System.out.println("Brightness decreased.");
												}
											}
										}
										case MP3 mp3 -> {
											switch (actionIndex) {
												case 1 -> {
													mp3.increaseVolume();
													System.out.println("Volume increased.");
												}
												case 2 -> {
													mp3.decreaseVolume();
													System.out.println("Volume decreased.");
												}
											}
										}
										case MP4 mp4 -> {
											switch (actionIndex) {
												case 1 -> {
													mp4.increaseBrightness();
													System.out.println("Brightness increased.");
												}
												case 2 -> {
													mp4.decreaseBrightness();
													System.out.println("Brightness decreased.");
												}
												case 3 -> {
													mp4.increaseVolume();
													System.out.println("Volume increased.");
												}
												case 4 -> {
													mp4.decreaseVolume();
													System.out.println("Volume decreased.");
												}
											}
										}
										default -> System.out.println("Media type not supported.");
									}
								} catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("Index out of bounds.");
								} catch (NumberFormatException e) {
									System.out.println("Index must be a number.");
								}
							}
							break;
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Index out of bounds.");
						} catch (NumberFormatException e) {
							System.out.println("Index must be a number.");
						}
					}
				case "0":
					break;
				default:
					System.out.println("Invalid input.");
					break;
			}
		}

		 */
	}
}