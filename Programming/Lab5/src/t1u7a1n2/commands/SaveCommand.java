package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;
import t1u7a1n2.Parser;

import java.io.IOException;

/**
 * Command saves collection to file
 */
public class SaveCommand extends CommandWithoutArgs {
	private CollectionManager collectionManager;
	private Parser parser;
	private String filename;
	
	public SaveCommand(CollectionManager collectionManager, Parser parser, String filename) {
		super("save", "save collection to file");
		this.collectionManager = collectionManager;
		this.parser = parser;
	}
	
	@Override
	public String doRun() {
		try {
			parser.writeStringToFile(filename, parser.fromCollectionManagerToJson(collectionManager));
			return "Collection was successfully saved to " + filename + " file.";
		}
		catch (IOException e) {
			return "Collection saving was failed - there is no " + filename + " file.";
		}
	}
}
