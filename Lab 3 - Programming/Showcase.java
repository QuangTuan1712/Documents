import java.util.Objects;

public class Showcase extends Thing implements Description{
	private Locations location;
	
	public Showcase(String name, Locations location) {
		super(name);
		this.location = location;
	}
	public Showcase(String name, String inscription) {
		super(name, inscription);
	}
	
	public void setLocation(Locations location) {
		this.location = location;
	}
	public Locations getLocation() {
		return location;
	}
	@Override
	public void description() {
		if (this.location == null) {
			System.out.println("    There was a showcase, above which was the inscription " + this.getInscription() + ". ");
		}
		else {
			System.out.println("    There were showcases, which illuminated from inside " + this.location.toString() + ".");
		}
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Location: " + this.location + ", Inscription: " + this.getInscription();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showcase)) return false;
        Showcase show = (Showcase) o;
        return Objects.equals(this.getName(), show.getName()) &&
                Objects.equals(this.location, show.location)&&
                Objects.equals(this.getInscription(), show.getInscription());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getName(), this.location, this.getInscription());
    }
}
