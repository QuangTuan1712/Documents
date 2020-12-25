import java.util.Objects;

public class Sign extends Inhuman{
	private Locations location;
	
	public Sign(String name, Locations location, String inscription) {
		super(name, inscription);
		this.location = location;
	}
	public void setLocation(Locations location) {
		this.location = location;
	}
	public Locations getLocation() {
		return location;
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Location: " + this.location + ", Inscription: " + this.getInscription();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showcase)) return false;
        Sign sign = (Sign) o;
        return Objects.equals(this.getName(), sign.getName()) &&
                Objects.equals(this.getLocation(), sign.location)&&
                Objects.equals(this.getInscription(), sign.getInscription());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getName(), this.location, this.getInscription());
    }
}
