import java.util.Objects;

public class Showcase extends Thing implements Descrip, ShowProducts {

	public Showcase(Items items) {
		super(items);
	}
	public Showcase(Items items, String inscrip) {
		super(items, inscrip);
	}
	
	@Override
	public void descrip(){
		if (this.getInscrip() == null) {
			System.out.println("    There were showcases, which illuminated from inside along the walls.");
		}
		else {
			System.out.println("    There was a showcase, above which was the inscription \"" + this.getInscrip() + "\".");
		}
	}
	@Override
	public void showProducts() {
		if (this.getInscrip() == null) {
			System.out.print("    In these showcases: ");
		}
		else {
			System.out.print("    In this showcase: ");
		}
		System.out.println(this.getItems().toString() + ".\n");
	}
	@Override
	public String toString() {
		return "Items: " + this.getItems() + ", Inscription: " + this.getInscrip();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showcase)) return false;
        Showcase show = (Showcase) o;
        return Objects.equals(this.getItems(), show.getItems())&&
                Objects.equals(this.getInscrip(), show.getInscrip());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getItems(), this.getInscrip());
    }
}
