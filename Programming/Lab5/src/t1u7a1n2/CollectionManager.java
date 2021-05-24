package t1u7a1n2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import t1u7a1n2.flat.Flat;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class to manage collection's elements
 */
public class CollectionManager{
	
	@JsonIgnore
	private final Date time = new Date();
	private LinkedList<Flat> list;
	
	public void setTime(Date time) {
	}
	
	@JsonIgnore
	public void setMyListType(String myListType) {
	}
	
	public CollectionManager() {
		this.list = new LinkedList<>();
	}
	
	/**
	 * @param list of collection's elements
	 */
	public CollectionManager(LinkedList<Flat> list) {
		this.list = list;
	}
	
	public LinkedList<Flat> getList(){
		return list;
	}
	
	public void setList(LinkedList<Flat> list) {
		this.list = list;
	}
	
	@JsonIgnore
	public String getType() {
		return "LinkedList";
	}
	
	@JsonIgnore
	public int getAmountOfElements() {
		return list.size();
	}
	
	public String getTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		return dateFormat.format(time);
	}
	
	/**
	 * Update element with given ID
	 * @param id given ID
	 * @param flat element update value
	 * @return String result of method work. If it finished successful
	 */
	public String updateId(int id, Flat element) {
		for (int i=0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.set(i, element);
				return "Element with id: " + id + " was successfully updated.";
			}
		}
		return "There is no element with id: " + id + " in collection.";
	}
	
	/**
	 * Add element to collection
	 * @param flat element to add
	 * @return String result of method work. If it finished successful
	 */
	public String add(Flat element) {
		list.add(element);
		return "Element with id: " + element.getId() + " was successfully added.";
	}
	
	/**
	 * Remove element with given id
	 * @param id given ID
	 * @return String result of method work. If it finished successful
	 */
	public String removeById(int id) {
		for (int i=0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				return "Element with id: " + id + " was successfully removed.";
			}
		}
		return "There is no element with id: " + id + " in collection.";
	}
	
	/**
	 * Clear collection
	 * @return String result of method work. If it finished successful
	 */
	public String clear() {
		list.clear();
		return "The collection was successfully cleared.";
	}
	
	/**
	 * Remove first element 
	 * @return first element
	 */
	public Flat removeHead() {
		Flat flat = list.get(0);
		list.remove(0);
		return flat;
	}
	
	/**
	 * Remove element with greater then given element
	 * @param element given element
	 * @return String result of method work. If it finished successful
	 */
	public String removeGreater(Flat element) {
		int beginSize = list.size();
		for (Flat flat:list) {
			if (flat.compareTo(element) > 0) {
				list.remove(flat);
			}
		}
		return (beginSize - list.size()) + " elements greater then entered were successfully removed.";
	}
	
	/**
	 * Remove element with lower then given element
	 * @param element given element
	 * @return String result of method work. If it finished successful
	 */
	public String removeLower(Flat element) {
		int beginSize = list.size();
		for (Flat flat:list) {
			if (flat.compareTo(element) < 0) {
				list.remove(flat);
			}
		}
		return (beginSize - list.size()) + "elements lower then entered were successfully removed.";
	}
	
	/**
	 * Sum of the values of the number of rooms
	 * @return String result of method work
	 */
	public String sumOfNumberOfRooms() {
		int Sum = 0;
		for (Flat flat:list) {
			Sum += flat.getNumberOfRooms();
		}
		return "Number of rooms: " + Sum;
	}
	
	/**
	 * Sort by creation date of flat
	 * @return element with greater creation date
	 * @throws IndexOutOfBoundsException if no elements in collection
	 */
	public Flat maxByCreationDate() throws IndexOutOfBoundsException {
		try {
			Flat element = list.get(0);
			for (Flat flat:list) {
				if (flat.getDate().after(element.getDate())) {
					element = flat;
				}
			}
			return element;
		}catch (IndexOutOfBoundsException e) {
			throw new InvalidArgumentsException("No elements in collection. Can't choose the greater by CreationDate.");
		}
	}
	
	/**
	 * Group by name of flat
	 * @return HashMap with name and number of flats
	 * @throws IndexOutOfBoundsException if no elements in collection
	 */
	public HashMap<String, Integer> groupCountingByName() throws IndexOutOfBoundsException {
		try {
			HashMap<String, Integer> group = new HashMap<String, Integer>();
			for (Flat flat:list) {
				if (group.isEmpty() || group.containsKey(flat.getName()) == false) {
					group.put(flat.getName(), 1);
				}else {
					int a = group.get(flat.getName());
					group.put(flat.getName(), a+1);
				}
			}
			return group;
		}catch (IndexOutOfBoundsException e) {
			throw new InvalidArgumentsException("No elements in collection. Can't choose the best by CreationDate.");
		}
	}
}