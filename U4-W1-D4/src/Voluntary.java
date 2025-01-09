public class Voluntary implements Worker {
	private String name;
	private String age;
	private String CV;

	public Voluntary (String name, String age, String CV) {
		this.name = name;
		this.age = age;
		this.CV = CV;
	}

	public String getName () {
		return this.name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getAge () {
		return this.age;
	}

	public void setAge (String age) {
		this.age = age;
	}

	public String getCV () {
		return this.CV;
	}

	public void setCV (String CV) {
		this.CV = CV;
	}

	@Override
	public String checkIn () {
		return "Undefined";
	}

	@Override
	public String toString () {
		return "Voluntary{" +
			"name='" + this.name + '\'' +
			'}';
	}
}
