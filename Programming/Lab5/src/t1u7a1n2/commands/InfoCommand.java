package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;

/**
 *Command prints information about the collection (type, initialization date, number of elements, etc.) to the standard output stream
 */
public class InfoCommand extends CommandWithoutArgs{
	private CollectionManager collectionManager;
	
	public InfoCommand(CollectionManager collectionManager) {
		super("info", "print information about the collection (type, initialization date, number of elements, etc.) to the standard output stream");
		this.collectionManager = collectionManager;
	}
	
	@Override
	public String doRun() {
		return "This collection was created: " + collectionManager.getTime() + "\n"
				+ "Collection type: " + collectionManager.getType() + "\n"
				+ "Amount of collection's elements: " + collectionManager.getAmountOfElements() + "\n";
	}
}
