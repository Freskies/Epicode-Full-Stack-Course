package Exercise1;

public class Ex1 {
	public static boolean stringBool (String word) {
		return word.length() % 2 == 0;
	}

	public static boolean isLeapYear (int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
}
