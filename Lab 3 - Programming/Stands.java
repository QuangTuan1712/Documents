import java.util.Objects;

public class Stands extends Thing implements ShowProducts {
	
	public Stands(Items items) {
		super(items);
	}
	
	@Override
	public void showProducts() {
		System.out.println("    On special wooden stands: " + this.getItems().toString() + ".\n");
	}
	@Override
	public String toString() {
		return "Items: " + this.getItems() + ", Inscription: " + this.getInscrip();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stands)) return false;
        Stands stands = (Stands) o;
        return Objects.equals(this.getItems(), stands.getItems())&&
                Objects.equals(this.getInscrip(), stands.getInscrip());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getItems(), this.getInscrip());
    }
}
