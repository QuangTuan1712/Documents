import java.util.Objects;

public class Sign extends ObjectLab {
	
	public Sign(String inscrip) {
		super(inscrip);
	}
	
	@Override
	public String getInscrip() {
		return "\"" + super.getInscrip() + "\"";
	}
	@Override
	public String toString() {
		return "Inscription: " + this.getInscrip();
	}
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sign)) return false;
        Sign sign = (Sign) o;
        return Objects.equals(this.getInscrip(), sign.getInscrip());
	}
	@Override
	public int hashCode() {
        return Objects.hash(this.getInscrip());
    }
}
