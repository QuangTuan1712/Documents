
public class Main {
	public static void main(String[] args) {
		Neznayka nez = new Neznayka("Nezznayka", Locations.STREET);
		Kozlik koz = new Kozlik("Kozlik", Locations.STREET);
		Sign sign = new Sign("sign", Locations.DOOR, "Sale of various goods");
		nez.seeASign(sign);
		koz.seeASign(sign);
		nez.location(Locations.STORE);
		koz.location(Locations.STORE);
		Items guns = new Items("guns of various systems, calibers");
		guns.location(Locations.STAND);
		Items weapons = new Items("Various pistols, knives, finks, daggers, brushes and brass knuckles");
		weapons.location(Locations.COUNTER);
		Showcase show_1 = new Showcase("Showcases", Locations.WALL);
		show_1.description();
		Items items = new Items("sets of thieves' master keys, steel files, drills, pliers, nippers, crowbars, crowbars for breaking locks, autogenous devices for cutting fireproof cabinets and chests");
		items.location(Locations.SHOWCASES);
		Showcase show_2 = new Showcase("Showcase", "Police Utensils");
		show_2.description();
		Items policeItems = new Items("rubber electric batons of various styles, steel handcuffs, shackles, incendiary and tear bombs and other police items");
		policeItems.location(Locations.SHOWCASE);
	}
}
