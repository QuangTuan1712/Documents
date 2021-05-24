package t1u7a1n2.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import t1u7a1n2.CollectionManager;
import t1u7a1n2.Parser;

/**
 * Command finds the element with maximum creation date in the collection
 */
public class MaxByCreationDateCommand extends CommandWithoutArgs {
	private CollectionManager collectionManager;
	private Parser parser;
	
	public MaxByCreationDateCommand(CollectionManager collectionManager, Parser parser) {
		super("max_by_creation_date", "find the element with maximum creation date in the collection");
		this.collectionManager = collectionManager;
		this.parser = parser;
	}
	
	@Override
	public String doRun() {
		try {
			return "The element with maximum creation date is: \n" + parser.fromElementToString(collectionManager.maxByCreationDate());
		}
		catch (JsonProcessingException e) {
			return "Parsing got wrong.";
		}
		catch (IndexOutOfBoundsException e){
            return "Can't do remove_head command. " + e.getMessage();
        }
	}
}
