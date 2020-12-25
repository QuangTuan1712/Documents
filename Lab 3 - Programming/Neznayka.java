import java.util.Objects;

public class Neznayka extends Person implements Action{
	public Neznayka(String name, Locations location) {
		super(name, location);
		System.out.println(this.getName() + " walks " + this.getLocation().toString());
	}
	
	@Override
	public void seeASign(Sign sign) {
		System.out.print(this.getName() + " and ");
	}
	@Override
	public void enter(Locations ocation) {
		System.out.print(this.getName() + " and ");
	}
	@Override
	public void realize() {
		System.out.print(this.getName() + " and ");
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Location: " + this.getLocation();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kozlik)) return false;
        Neznayka nez = (Neznayka) o;
        return Objects.equals(this.getName(), nez.getName()) &&
                Objects.equals(this.getLocation(), nez.getLocation());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getLocation());
    }
}
