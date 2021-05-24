package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;

/**
 *Command clear collection - delete all elements
 */
public class ClearCommand extends CommandWithoutArgs {
	private CollectionManager collectionManager;
	
	public ClearCommand(CollectionManager collectionManager) {
		super("clear", "clear collection");
	}
	
	@Override
	public String doRun() {
		return collectionManager.clear();
	}
}
