
public abstract class Person {
	private String name;
	private int year;
	
	public Person(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setYear(int year) {
		this.year= year;
	}
	public int getYear() {
		return year;
	}
}
