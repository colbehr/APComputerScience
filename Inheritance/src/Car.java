/**
 * Car class definition
 * @author Bubba
 * 2015-Feb-02
 */
public class Car {
	public String make;
	public String model;
	private int year;
	public double price;

	public void setYear(int inYear) {
		year = inYear;
	}
	public int getYear() {
		return year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
}
