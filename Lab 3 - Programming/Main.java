
public class Main {
	public static void main(String[] args) {
		Neznayka nez = new Neznayka("Nezznayka", Locations.STREET);
		Kozlik koz = new Kozlik("Kozlik", Locations.STREET);
		Sign sign = new Sign("sign", Locations.DOOR, "Sale of various goods");
		nez.seeASign(sign);
		koz.seeASign(sign);
		nez.enter(Locations.STORE);
		koz.enter(Locations.STORE);
		nez.realize();
		koz.realize();
		Things guns = new Things("guns of various systems, calibers");
		guns.location(Locations.STAND);
		Things weapons = new Things("Various pistols, knives, finks, daggers, brushes and brass knuckles");
		weapons.location(Locations.COUNTER);
		Showcase show_1 = new Showcase("Showcases", Locations.WALL);
		Things things = new Things("sets of thieves' master keys, steel files, drills, pliers, nippers, crowbars, crowbars for breaking locks, autogenous devices for cutting fireproof cabinets and chests");
		things.location(Locations.SHOWCASES);
		Showcase show_2 = new Showcase("Showcase", "Police Utensils");
		Things policeItems = new Things("rubber electric batons of various styles, steel handcuffs, shackles, incendiary and tear bombs and other police items");
		policeItems.location(Locations.SHOWCASE);
	}
}
