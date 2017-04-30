/**
 * New Car class definition
 * 
 * @author JimWe 2015 February 2
 */
public class UsedCar {
	private String make;
	public String model;
	public int year = 1998;
	public double price;
	public double blueBookValue;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getBlueBookValue() {
		return blueBookValue;
	}

	public void setBlueBookValue(double blueBookValue) {
		this.blueBookValue = blueBookValue;
	}

}