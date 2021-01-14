import java.util.Objects;

public class Door extends ObjectLab {
	private Sign sign;
	
	public Door() {}
	public Door(Sign sign) {
		this.sign = sign;
	}
	
	public String showSign() {
		return "a sign over the door of one of the shops with the inscription " + sign.getInscrip() + ".";
	}
	public void setSign(Sign sign) {
		this.sign = sign;
	}
	public Sign getSign() {
		return sign;
	}
	@Override
	public String toString() {
		return "Inscription: " + this.getInscrip();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Door)) return false;
        Door door = (Door) o;
        return Objects.equals(this.getInscrip(), door.getInscrip());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getInscrip());
    }
}
