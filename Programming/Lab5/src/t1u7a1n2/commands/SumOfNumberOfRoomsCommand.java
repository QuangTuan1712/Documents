package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;

/**
 * Command prints the sum of the values of the number of rooms for all elements in the collection
 */
public class SumOfNumberOfRoomsCommand extends CommandWithoutArgs {
	private CollectionManager collectionManager;
	
	public SumOfNumberOfRoomsCommand(CollectionManager collectionManager) {
		super("sum_of_number_of_rooms", "print the sum of the values of the number of rooms for all elements in the collection");
		this.collectionManager = collectionManager;
	}
	
	@Override
	public String doRun() {
		return collectionManager.sumOfNumberOfRooms();
	}
}
