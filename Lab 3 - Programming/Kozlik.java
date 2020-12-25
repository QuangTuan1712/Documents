import java.util.Objects;

public class Kozlik extends Person implements Action{
	public Kozlik(String name, Locations location) {
		super(name, location);
		System.out.println(this.getName() + " walks " + this.getLocation().toString() + ".\n");
	}
	
	@Override
	public void seeASign(Sign sign) {
		System.out.println(this.getName() + " saw a sign " + sign.getLocation().toString() + " with the inscription " + sign.getInscription() + ".");
	}
	@Override
	public void enter(Locations location) {
		System.out.println(this.getName() + " entered " + location.toString() + ".");
	}
	@Override
	public void realize() {
		System.out.println(this.getName() + " realized what kind of products were sold here.\n");
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Location: " + this.getLocation();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kozlik)) return false;
        Kozlik koz = (Kozlik) o;
        return Objects.equals(this.getName(), koz.getName()) &&
                Objects.equals(this.getLocation(), koz.getLocation());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getLocation());
    }
}
