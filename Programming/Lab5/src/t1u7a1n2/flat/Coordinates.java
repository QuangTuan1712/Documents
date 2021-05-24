package t1u7a1n2.flat;

import t1u7a1n2.InvalidArgumentsException;

public class Coordinates {
	private Long x; //Поле не может быть null
	private double y;
	
	public Coordinates(Long x, double y) throws InvalidArgumentsException {
        if (x != null) {
		    this.x = x;
            this.y = y;
        }else {
        	throw new InvalidArgumentsException("Coordinates value is wrong.");
        }
    }
	
	public void setX(Long x) throws InvalidArgumentsException{
		if (x != null) {
			this.x = x;
		}else {
			throw new InvalidArgumentsException("Coordinates value is wrong.");
		}
	}
	public void setY(double y) {
		this.y = y;
	}
	public Long getX() {
        return x;
    }
	public double getY() {
        return y;
    }
	
	@Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }
}
