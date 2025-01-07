import java.util.Scanner;

public class Exercise2 {
	 public static void start () {
			Scanner scanner = new Scanner (System.in);
			System.out.print ("Insert the first string: ");
			String str1 = scanner.nextLine ();
			System.out.print ("Insert the first string: ");
			String str2 = scanner.nextLine ();
			System.out.print ("Insert the first string: ");
			String str3 = scanner.nextLine ();
			String format = "%s %s %s%n";
			System.out.printf (format, str1, str2, str3);
			System.out.printf (format, str3, str2, str1);
	 }
}
