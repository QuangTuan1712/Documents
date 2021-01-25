
public class Thing extends ObjectLab {
	private Items items;
	
	public Thing(Items items) {
		this.items = items;
	}
	public Thing(Items items, String inscrip) {
		super(inscrip);
		this.items = items;
	}
	
	public void setItems(Items items) {
		this.items = items;
	}
	public Items getItems() {
		return items;
	}
}
