import java.util.Objects;

public class Neznayka extends Person implements SeeASign, EnterTheStore {
	
	public Neznayka(String name, int year) {
		super(name, year);
		System.out.println(name + " walks on the street.");
	}
	
	@Override
	public void seeASign(Door door) {
		System.out.print(this.getName() + " and ");
	}
	@Override
	public void enterTheStore(Store store) {
		System.out.print(this.getName() + " and ");
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Year: " + this.getYear();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Neznayka)) return false;
        Neznayka nez = (Neznayka) o;
        return Objects.equals(this.getName(), nez.getName()) &&
                Objects.equals(this.getYear(), nez.getYear());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getYear());
    }
}
