package Es3;

public class Main {
	public static void main (String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.add("Alice", "1234567890");
		phoneBook.add("Bob", "0987654321");
		phoneBook.add("Charlie", "6789054321");
		phoneBook.remove("Bob");
		System.out.println("~" + phoneBook.getName("6789054321"));
		System.out.println("*" + phoneBook.getPhone("Alice"));
		phoneBook.print();
	}
}
