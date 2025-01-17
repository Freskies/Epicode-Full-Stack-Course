package Library;

public class IllegalISBNProvided extends RuntimeException {
	public IllegalISBNProvided (String message) {
		super(message);
	}
}
