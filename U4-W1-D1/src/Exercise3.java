public class Exercise3 {
	public static void rectanglePerimeter(int a, int b) {
		System.out.println (a * b);
	}

	public static void evenOdd (int n) {
		System.out.println (n % 2);
	}

	public static void trianglePerimeter(double a, double b, double c) {
		if (a > b + c || b > a + c || c > a + b) throw new Error ("Invalid triangle");
		double p = (a + b + c) / 2;
		double area = Math.sqrt (p * (p - a) * (p - b) * (p - c));
		System.out.println (area);
	}
}
