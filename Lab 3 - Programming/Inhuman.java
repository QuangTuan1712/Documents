
public abstract class Inhuman{
	private String name;
	private String inscription;
	
	public Inhuman(String name) {
		this.name = name;
	}
	public Inhuman(String name, String inscription) {
		this.name = name;
		this.inscription = inscription;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setInscription(String inscription) {
		this.inscription = inscription;
	}
	public String getInscription() {
		return "\"" + inscription + "\"";
	}
}
