import java.util.Objects;

public class Human extends Person implements SeeASign, EnterTheStore {
	private Walk walk;
	
	public Human(String name,int ability, int weariness) {
		super(name,ability, weariness);
		walk = new Walk(ability);
	}
	
	@Override
	public void seeASign(Door door) {
		System.out.print("They see " + door.showSign() + "\n");
	}
	@Override
	public void enterTheStore(Store store) {
		if (getAbility() > 10) {
			if (this.want(getWeariness()) == 1) System.out.println(this.getName() + " enter the store.");
			else if (this.want(getWeariness()) == 0) System.out.println(this.getName() + " keep walking.");
			else System.out.println(getName() + " can't walks");
		}
	}
	@Override
	public String toString() {
		return "Name: " + this.getName() + ", Weariness: " + this.getWeariness();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return Objects.equals(this.getName(), human.getName()) &&
                Objects.equals(this.getWeariness(), human.getWeariness());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getWeariness());
    }
    

	
	public int want(int want){
		class Think {
			private int i = -1;
			Think(int want) {}
			void WantToEnterStore() {
				if (want < 50) i = 1;
				else if ((want > 49) && (want < 100)) i = 0;
			}
		}
		Think think = new Think(getWeariness());
		think.WantToEnterStore();
		return think.i;
	}
	void tryToWalk() {
		walk.walk();
	}
}
