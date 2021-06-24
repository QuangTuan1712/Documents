import java.util.Objects;

public class Counter extends Thing implements ShowProducts {

	public Counter(Items items) {
		super(items);
	}
	
	@Override
	public void showProducts() {
		System.out.println("    On the counter: " + this.getItems().toString() + ".\n");
	}
	@Override
	public String toString() {
		return "Items: " + this.getItems() + ", Inscription: " + this.getInscrip();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Counter)) return false;
        Counter coun = (Counter) o;
        return Objects.equals(this.getItems(), coun.getItems())&&
                Objects.equals(this.getInscrip(), coun.getInscrip());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getItems(), this.getInscrip());
    }
}
