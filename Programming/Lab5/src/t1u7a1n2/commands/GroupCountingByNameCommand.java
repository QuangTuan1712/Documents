package t1u7a1n2.commands;

import t1u7a1n2.CollectionManager;
import java.util.HashMap;
import java.util.Set;

/**
 * Command groups element in the collection by name
 */
public class GroupCountingByNameCommand extends CommandWithoutArgs {
	private CollectionManager collectionManager;
	
	public GroupCountingByNameCommand(CollectionManager collectionManager) {
		super("group_counting_by_name", "group element in the collection by name");
		this.collectionManager = collectionManager;
	}
	
	@Override
	public String doRun() {
		HashMap<String, Integer> hashMap = collectionManager.groupCountingByName();
		Set<String> keySet = hashMap.keySet();
		StringBuilder str = new StringBuilder();
		str.append("List of names:\n");
		for (String key : keySet) {
			str.append(key).append(" - ").append(hashMap.get(key)).append("\n");
		}
		return str.toString();
	}
}
