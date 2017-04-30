/**
 * Car dealer class definition
 * @author JimWe
 * 2015 February 2
 */
public class CarDealer {

	public static void main(String[] args) {
		UsedCar usedCar = new UsedCar();
		NewCar  newCar = new NewCar();
		LightTruck lightTruck = new LightTruck();
		
		System.out.println(usedCar.toString() + " year: " + usedCar.getYear());
		System.out.println(newCar.toString() + "  year: " + newCar.getYear());
		System.out.println(lightTruck.toString() + "  year: " + lightTruck.getYear());
	}
}
