package t1u7a1n2.flat;

import t1u7a1n2.InvalidArgumentsException;

/**
 * The class-field in Flat class
 */
public class House {
	private String name; //Поле не может быть null
	private int year; //Значение поля должно быть больше 0
	private long numberOfLifts; //Значение поля должно быть больше 0
	
	public House() {
	}
	
	/**
	 * @param name name of flat
	 * @param year year of flat
	 * @param numberOfLifts number of lifts of flat
	 */
	public House(String name, int year, long numberOfLifts) {
		this.name = name;
		this.year = year;
		this.numberOfLifts = numberOfLifts;
	}
	
	public void setName(String name) throws InvalidArgumentsException{
		if (name != null) {
			this.name = name;
		}else {
			throw new InvalidArgumentsException("House's name can't be null.");
		}
	}
	
	public void setYear(int year) throws InvalidArgumentsException{
		if (year > 0) {
			this.year = year;
		}else {
			throw new InvalidArgumentsException("Year can't be less then 0.");
		}
	}
	
	public void setNumberOfLifts(long numberOfLifts) throws InvalidArgumentsException{
		if (numberOfLifts > 0) {
			this.numberOfLifts = numberOfLifts;
		}else {
			throw new InvalidArgumentsException("Number of lifts can't be less then 0.");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public long getNumberOfLifts() {
		return numberOfLifts;
	}
}
