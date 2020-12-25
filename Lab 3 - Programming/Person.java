
public abstract class Person{
	private String name;
	private Locations location;
	
	public Person(String name, Locations location) {
		this.name = name;
		this.location = location;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setLocation(Locations location) {
		this.location = location;
	}
	public Locations getLocation() {
		return location;
	}
}
