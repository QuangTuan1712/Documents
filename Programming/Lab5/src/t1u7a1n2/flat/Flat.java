package t1u7a1n2.flat;

import t1u7a1n2.InvalidArgumentsException;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Class Flat
 */
public class Flat implements Comparable<Flat> {
	private Date creationDate = Calendar.getInstance().getTime(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
	private Integer id = Math.abs((Integer) Objects.hash(creationDate)); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
	private String name; //Поле не может быть null, Строка не может быть пустой
	private Coordinates coordinates; //Поле не может быть null
    private Long area; //Значение поля должно быть больше 0
    private long numberOfRooms; //Значение поля должно быть больше 0
    private Furnish furnish; //Поле может быть null
    private View view; //Поле может быть null
    private Transport transport; //Поле может быть null
    private House house; //Поле может быть null
    
    /**
     * @param name name of flat
     * @param coordinates coordinates of flat
     * @param area area of flat
     * @param numberOfRooms number of rooms of flat
     * @param furnish furnish around flat
     * @param view view around flat
     * @param transport number of vehicles around flat
     * @param house location of flat
     */
    public Flat(Integer id, String name, Coordinates coordinates, Long area, long numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
    	this.id = id;
    	this.name = name;
    	this.coordinates = coordinates;
    	this.area = area;
    	this.numberOfRooms = numberOfRooms;
    	this.furnish = furnish;
    	this.view = view;
    	this.transport = transport;
    	this.house = house;
    }
    
    public Flat() {
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setCoordinates(Coordinates coordinates) {
    	this.coordinates = coordinates;
    }
    
    public void setArea(Long area) {
    	if (area > 0) {
    		this.area = area;
    	}else {
    		throw new InvalidArgumentsException("Area can't be less then 0.");
    	}
    }
    
    public void setNumberOfRooms(long numberOfRooms) {
    	if (numberOfRooms > 0) {
    	    this.numberOfRooms = numberOfRooms;
    	}else {
    		throw new InvalidArgumentsException("Number of rooms can't be less then 0.");
    	}
    }
    
    public void setFurnish(Furnish furnish) {
    	this.furnish = furnish;
    }
    
    public void setFurnish(String str) throws InvalidArgumentsException{
        boolean rightString = false;
        for(Furnish furnish : Furnish.values()){
            if(str.equals(furnish.toString())){
                this.furnish = furnish;
                rightString = true;
            }
        }
        if(!rightString){
            throw new InvalidArgumentsException("There is now such value for furnish.");
        }
    }
    
    public void setView(View view) {
    	this.view = view;
    }
    
    public void setView(String str) throws InvalidArgumentsException{
        boolean rightString = false;
        for(View view : View.values()){
            if(str.equals(view.toString())){
                this.view = view;
                rightString = true;
            }
        }
        if(!rightString){
            throw new InvalidArgumentsException("There is now such value for difficulty.");
        }
    }
    
    public void setTransport(Transport transport) {
    	this.transport = transport;
    }
    
    public void setTransport(String str) throws InvalidArgumentsException{
        boolean rightString = false;
        for(Transport transport : Transport.values()){
            if(str.equals(transport.toString())){
                this.transport = transport;
                rightString = true;
            }
        }
        if(!rightString){
            throw new InvalidArgumentsException("There is now such value for difficulty.");
        }
    }
    
    public void setHouse(House house) {
    	this.house = house;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }
    
    public Coordinates getCoordinates() {
    	return coordinates;
    }
    
    public Date getDate() {
    	return creationDate;
    }
    
    public Long getArea() {
    	return area;
    }
    
    public long getNumberOfRooms() {
    	return numberOfRooms;
    }
    
    public Furnish getFurnish() {
    	return furnish;
    }
    
    public View getView() {
    	return view;
    }
    
    public Transport getTransport() {
    	return transport;
    }
    
    public House getHouse() {
    	return house;
    }

    @Override
    public int compareTo(Flat abc) {
    	return id.compareTo(abc.getId());
    }
    @Override
    public int hashCode() {
    	return Objects.hash(id, name, coordinates, area, numberOfRooms, furnish, view, transport, house);
    }
}
