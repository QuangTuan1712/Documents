
public class Items extends Thing implements Location{
	public Items(String name) {
		super(name);
	}
	@Override
	public void location(Locations location) {
		System.out.println("    " + location.toString() + ": "+ this.getName() + ".\n");
	}
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
