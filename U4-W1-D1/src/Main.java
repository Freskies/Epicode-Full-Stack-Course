public class Main {
	public static void main (String[] args) {
		System.out.println ("------- EXERCISE 1");
		Main.ex1 (false);

		System.out.println ("------- EXERCISE 2");
		Main.ex2 (false);

		System.out.println ("------- EXERCISE 3");
		Main.ex3 (true);
	}

	private static void ex1 (boolean run) {
		if (!run) return;
		Exercise1.multiply (2, 2);
		Exercise1.concat ("Ciola", 4);
		Exercise1.insert (new String[] {"a", "b", "c", "d", "e"}, "CIOLA");
	}

	private static void ex2 (boolean run) {
		if (!run) return;
		Exercise2.start ();
	}

	private static void ex3 (boolean run) {
		if (!run) return;
		Exercise3.rectanglePerimeter (20, 40);
		Exercise3.evenOdd (5);
		Exercise3.trianglePerimeter (5, 5, 5);
	}
}