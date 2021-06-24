import java.util.Objects;

public class Store extends ObjectLab implements Descrip {
	
	public Store() {}
	
	@Override
	public void descrip() {
		System.out.println("Products were sold in the store:\n");
	}
	@Override
	public String toString() {
		return "Inscription: " + this.getInscrip();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return Objects.equals(this.getInscrip(), store.getInscrip());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getInscrip());
    }
}
