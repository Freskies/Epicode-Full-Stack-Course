import Exercise1.Ex1;
import Exercise2.Ex2;
import Exercise3.Ex3;
import Exercise4.Ex4;

public class Main {
	public static void main (String[] argv) {
		System.out.println("-------------EX 1");
		System.out.println(Ex1.stringBool("hello"));
		System.out.println(Ex1.isLeapYear(1904));

		System.out.println("-------------EX 2");
		if (false) Ex2.start();

		System.out.println("-------------EX 3");
		if (false) Ex3.start();

		System.out.println("-------------EX 4");
		Ex4.start();
	}
}