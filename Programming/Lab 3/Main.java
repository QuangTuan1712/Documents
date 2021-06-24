
public class Main {
	public static void main(String[] args) {
		Neznayka nez = new Neznayka("Neznayka", 17);
		Kozlik koz = new Kozlik("Kozlik", 18);
		Sign sign = new Sign("Sale of various goods");
		Door door = new Door(sign);
		nez.seeASign(door);
		koz.seeASign(door);
		Store store = new Store();
		nez.enterTheStore(store);
		koz.enterTheStore(store);
		store.descrip();
		Stands stands = new Stands(Items.ON_STANDS);
		stands.showProducts();
		Counter counter = new Counter(Items.ON_COUNTER);
		counter.showProducts();
		Showcase case_1 = new Showcase(Items.ON_SHOWCASE_1);
		case_1.descrip();
		case_1.showProducts();
		Showcase case_2 = new Showcase(Items.ON_SHOWCASE_2, "Police Utensils");
		case_2.descrip();
		case_2.showProducts();
	}
}
