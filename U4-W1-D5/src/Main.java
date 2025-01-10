import Media.Media;
import MyMedia.MP3;
import MyMedia.MP4;
import MyMedia.PNG;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		Media[] mediaList = new Media[5];
		String input;
		int mediaCount = 0;

		while (mediaCount < Player.MEDIA_REQUIRED) {
			String title;
			int duration = 0;

			System.out.println("###########");
			System.out.println("1. Load PNG");
			System.out.println("2. Load MP3");
			System.out.println("3. Load MP4");
			System.out.println("0. Exit");
			System.out.print("-> ");
			input = scanner.nextLine();

			// GET TITLE
			switch (input) {
				case "0":
					return;
				case "1":
				case "2":
				case "3":
					title = Main.askTitle(scanner);
					break;
				default:
					System.out.println("Invalid input.");
					continue;
			}

			// GET DURATION
			switch (input) {
				case "1":
					break;
				case "2":
				case "3":
					duration = Main.askDuration(scanner);
					break;
				default:
					System.out.println("Invalid input.");
					continue;
			}

			// LOAD MEDIA
			switch (input) {
				case "1":
					mediaList[mediaCount] = new PNG(title);
					System.out.println("PNG loaded.");
					break;
				case "2":
					mediaList[mediaCount] = new MP3(title, duration);
					System.out.println("MP3 loaded.");
					break;
				case "3":
					mediaList[mediaCount] = new MP4(title, duration);
					System.out.println("MP4 loaded.");
					break;
				default:
					System.out.println("Invalid input.");
					continue;
			}

			// INCREMENT MEDIA COUNT
			mediaCount++;
		}

		System.out.println("All media loaded.");
		Player player = new Player(mediaList);
		System.out.println("Player created.");

		input = "";
		while (!input.equals("0")) {
			System.out.println("###########");
			System.out.println("1. Open media");
			System.out.println("2. Modify media");
			System.out.println("0. Exit");
			System.out.print("-> ");
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
	}

	private static String askTitle (Scanner scanner) {
		while (true) {
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			if (title.isEmpty())
				System.out.println("Title cannot be empty.");
			else return title;
		}
	}

	private static int askDuration (Scanner scanner) {
		while (true) {
			try {
				System.out.print("Enter duration: ");
				String input = scanner.nextLine();
				int duration = Integer.parseInt(input);
				if (duration <= 0)
					System.out.println("Duration cannot be less than or equal to 0.");
				else return duration;
			} catch (NumberFormatException e) {
				System.out.println("Duration must be a number.");
			}
		}
	}
}