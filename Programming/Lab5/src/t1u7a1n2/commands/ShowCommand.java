package t1u7a1n2.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import t1u7a1n2.CollectionManager;
import t1u7a1n2.Parser;

/**
 * Command shows all collection elements
 */
public class ShowCommand extends CommandWithoutArgs {
	private CollectionManager collectionManager;
	private Parser parser;
	
	public ShowCommand(CollectionManager collectionManager, Parser parser) {
		super("show", "print to standard output all elements of the collection in string representation");
		this.collectionManager = collectionManager;
		this.parser = parser;
	}
	
	@Override
	public String doRun() {
		try {
			if (collectionManager.getAmountOfElements() != 0) {
				return parser.fromCollectionManagerToJsonElements(collectionManager);
			}else {
				return "No elements in collection.";
			}
		}
		catch (JsonProcessingException e){
	        return "Parsing was failed.";
		}
	}
}
