package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;
import t1u7a1n2.InvalidArgumentsException;

/**
 * Command removes element from collection by it's ID
 */
public class RemoveByIDCommand extends Command {
	private final CollectionManager collectionManager;
	private int id;
	
	public RemoveByIDCommand(CollectionManager collectionManager) {
		super("remove_by_id id", "remove an item from the collection by its id");
		this.collectionManager = collectionManager;
	}
	
	@Override
	public String doRun() {
		return collectionManager.removeById(id);
	}
	
	@Override
	public void validateArguments() {
        String[] args = this.getArgs();
        if(args.length == 2){
            this.id = Integer.parseInt(args[1]);
        }else {
            throw new InvalidArgumentsException("Remove_by_id command has the only argument - id of the element.");
        }
    }
}
