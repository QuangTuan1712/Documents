
public class Things extends Inhuman implements Location{
	public Things(String name) {
		super(name);
	}
	@Override
	public void location(Locations location) {
		System.out.println(location.toString() + ": "+ this.getName() + ".\n");
	}
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
