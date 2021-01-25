
public abstract class Person {
	private String name;
	private int ability;
	private int weariness;
	
	public Person(String name, int ability, int weariness) {
		this.name = name;
		this.ability = ability;
		this.weariness = weariness;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		try{
			if (haveName()) return name;
			else {
				throw new CorrectException("Not name");
			}
		} catch(ExistException e) {
			return e.getExc();
		} catch(CorrectException e) {
			e.printStackTrace();
			return "\"No name\"";
		}
	}
	public boolean haveName() {
		if (name==null) throw new ExistException("Need name");
        return name.equals("")?false:true;
	}
	public void setWeariness(int weariness) {
		this.weariness = weariness;
	}
	public int getWeariness() {
		try {
			if ((weariness >= 0)&&(weariness <= 100)) return weariness;
			else {
				throw new TestException("Weariness < 0 or > 100");
			}
		} catch(TestException e) {
			return 0;
		}
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public int getAbility() {
		try {
			if (ability >= 0) return ability;
			else {
				throw new TestException("Ability < 0");
			}
		} catch(TestException e) {
			return 0;
		}
	}
	
	class Walk{
		boolean abilityToWalk;
		Walk(int ability) {
			if (ability > 9) abilityToWalk = true;
			else abilityToWalk = false;
		}
		void walk() {
			if (abilityToWalk) System.out.println(getName() + " walks on the street.");
			else System.out.println(getName() + " stays at home.");
		}
	}
}
