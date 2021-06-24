import java.util.Objects;

public class Kozlik extends Person implements SeeASign, EnterTheStore {
	
	public Kozlik(String name, int year) {
		super(name, year);
		System.out.println(name + " walks on the street.\n");
	}
	
	@Override
	public void seeASign(Door door) {
		System.out.println(this.getName() + " see " + door.showSign());
	}
	@Override
	public void enterTheStore(Store store) {
		System.out.println(this.getName() + " enter the store.\n");
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Year: " + this.getYear();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kozlik)) return false;
        Kozlik koz = (Kozlik) o;
        return Objects.equals(this.getName(), koz.getName()) &&
                Objects.equals(this.getYear(), koz.getYear());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getYear());
    }
}
