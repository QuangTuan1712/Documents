package t1u7a1n2.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import t1u7a1n2.CollectionManager;
import t1u7a1n2.Parser;

/**
 * Command to find the first element in the collection and remove it
 */
public class RemoveHeadCommand extends CommandWithoutArgs{
	private CollectionManager collectionManager;
	private Parser parser;
	
	public RemoveHeadCommand(CollectionManager collectionManager, Parser parser) {
		super("remove_head", "find first element in the collection and remove it");
		this.collectionManager = collectionManager;
		this.parser = parser;
	}
	
	@Override
	public String doRun() {
		try {
			return "The first element is: \n" + parser.fromElementToString(collectionManager.removeHead());
		}
		catch (JsonProcessingException e) {
			return "Parsing got wrong.";
		}
		catch (IndexOutOfBoundsException e){
            return "Can't do remove_head command. " + e.getMessage();
        }
	}
}
