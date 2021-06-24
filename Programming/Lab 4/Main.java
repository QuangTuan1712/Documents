
public class Main {
	public static void main(String[] args) {
		Human nez = new Human("Neznayka", 50, 37);
		nez.tryToWalk();
		Human koz = new Human("Kozlik", 39, 18);
		koz.tryToWalk();
		Human vlad = new Human("Vladimir", 2, 59);
		vlad.tryToWalk();
		Human krot = new Human("Krotushka", 45, 90);
		krot.tryToWalk();
		new Human("", 2, 69).tryToWalk();
		Sign sign = new Sign("Sale of various goods");
		Door door = new Door(sign);
		nez.seeASign(door);
		Store store = new Store();
		nez.enterTheStore(store);
		koz.enterTheStore(store);
		vlad.enterTheStore(store);
		krot.enterTheStore(store);
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
