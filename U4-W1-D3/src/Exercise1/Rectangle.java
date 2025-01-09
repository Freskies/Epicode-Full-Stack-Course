package Exercise1;

public class Rectangle {
	private final double base;
	private final double height;

	public Rectangle (double base, double height) {
		this.base = base;
		this.height = height;
	}

	public double getPerimeter () {
		return this.base * 2 + this.height * 2;
	}

	public double getArea () {
		return this.base * this.height;
	}

	public void print () {
		System.out.printf("%s: Area: %.2f, Perimeter: %.2f", this, this.getArea(), this.getPerimeter());
	}

	@Override
	public String toString () {
		return "Rectangle{" +
			"base=" + this.base +
			", height=" + this.height +
			'}';
	}

	public static void printRectangles (Rectangle... rectangles) {
		double totArea = 0;
		double totPerimeter = 0;
		for (Rectangle rectangle : rectangles) {
			totArea += rectangle.getArea();
			totPerimeter += rectangle.getPerimeter();
			rectangle.print();
			System.out.println();
		}
		System.out.printf("Tot area: %s | Tot perimeter: %s", totArea, totPerimeter);
	}

	public static void main (String[] argv) {
		Rectangle r1 = new Rectangle(15, 20);
		Rectangle r2 = new Rectangle(7.6, 5.4);
		Rectangle.printRectangles(r1, r2);
	}
}
