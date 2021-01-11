
public abstract class Thing {
	private String name;
	private String inscription;
	
	public Thing(String name) {
		this.name = name;
	}
	public Thing(String name, String inscription) {
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
