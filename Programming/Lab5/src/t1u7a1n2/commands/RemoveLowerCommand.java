package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;
import t1u7a1n2.flat.Flat;

/**
 * Command removes all elements greater than given
 */
public class RemoveLowerCommand extends CommandWithoutArgs implements ElementNeed {
	private CollectionManager collectionManager;
	private Flat flat;
	
	public RemoveLowerCommand(CollectionManager collectionManager) {
		super("remove_lower {element}", "remove all items from the collection that are lower than the specified one");
		this.collectionManager = collectionManager;
	}
	
	@Override
	public String doRun() {
		return collectionManager.removeLower(flat);
	}
	
	@Override
	public void setFlatElement(Flat flatElement) {
		this.flat = flatElement;
	}
}
