package Es3;

import java.util.HashMap;

public class PhoneBook extends HashMap<String, String> {
	public void add (String name, String number) {
		this.put(name, number);
	}

	public String getPhone (String name) {
		return super.get(name);
	}

	public String getName (String phone) {
		for (String key : super.keySet())
			if (super.get(key).equals(phone))
				return key;
		return null;
	}

	public void remove (String name) {
		super.remove(name);
	}

	public void print () {
		for (String name : this.keySet())
			System.out.println(name + ": " + this.getPhone(name));
	}
}
