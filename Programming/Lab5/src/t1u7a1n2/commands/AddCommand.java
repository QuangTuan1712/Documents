package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;
import t1u7a1n2.flat.Flat;

/**
 * Command adds new element to collection
 */
public class AddCommand extends CommandWithoutArgs implements ElementNeed {
	private CollectionManager collectionManager;
	private Flat flat;
	
	public AddCommand(CollectionManager collectionManager) {
		super("add {element}", "add new element to collection");
	}
	
	@Override
	public String doRun() {
		return collectionManager.add(flat);
	}
	
	@Override
	public void setFlatElement(Flat flatElement) {
		this.flat = flatElement;
	}
}
