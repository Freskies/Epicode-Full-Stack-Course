import java.util.Arrays;

public class Exercise1 {
	public static void multiply (int a, int b) {
		System.out.println(a * b);
	}

	public static void concat (String text, int number) {
		System.out.println(text + number);
	}

	public static void insert (String[] array, String text) {
		if (array.length != 5) throw new Error("The Array must be of length 5");
		String[] newArray = new String[6];
		for (int i = 0; i < 6; i++) {
			String element;
			if (i < 2) element = array[i];
			else if (i == 2) element = text;
			else element = array[i - 1];
			newArray[i] = element;
		}
		System.out.println(Arrays.toString(newArray));
	}
}
