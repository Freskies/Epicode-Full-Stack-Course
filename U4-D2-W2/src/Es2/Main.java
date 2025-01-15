package Es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		ArrayList<Integer> a = Main.getRandomOrderedList(50);
		System.out.println(a);
		System.out.println(Main.baseAdd(a));
		System.out.println("----");
		Main.print(a, false);
	}

	public static ArrayList<Integer> getRandomOrderedList (int length) {
		ArrayList<Integer> list = new ArrayList<>(length);
		for (int i = 0; i < length; i++)
			list.add((int) Math.floor(Math.random() * 101));
		Collections.sort(list);
		return list;
	}

	public static ArrayList<Integer> baseAdd (ArrayList<Integer> a) {
		ArrayList<Integer> b = new ArrayList<>(a);
		b.addAll(a.reversed());
		return b;
	}

	public static void print (List<?> l, boolean even) {
		int index = 0;
		for (Object el : l)
			if (index++ % 2 == (even ? 0 : 1))
				System.out.print(el + " ");
	}
}
