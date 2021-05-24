package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;
import t1u7a1n2.InvalidArgumentsException;
import t1u7a1n2.flat.Flat;

/**
 * Command updates the element with given ID in collection
 */
public class UpdateIDCommand extends Command implements ElementNeed {
	private CollectionManager collectionManager;
	private Flat flat;
	private int id;
	
	public UpdateIDCommand(CollectionManager collectionManager) {
		super("update id {element}", "update the value of the collection element whose id is equal to the given");
		this.collectionManager = collectionManager;
	}
	
	@Override
	public String doRun() {
		return collectionManager.updateId(id, flat);
	}
	
	@Override
	public void validateArguments() {
		String[] args = getArgs();
		if (args.length == 2) {
			try {
				this.id = Integer.parseInt(args[1]);
			}
			catch (NumberFormatException e){
                throw new InvalidArgumentsException("Update command argument has to be long.");
            }
		}else {
            throw new InvalidArgumentsException("Update command has the only argument - id of the element.");
        }
	}
	
	@Override
	public void setFlatElement(Flat flatElement) {
        this.flat = flatElement;
    }
}
