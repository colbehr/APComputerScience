package converttemp;

/**
 * 
 * @author Colbehr 
 * assignment Fahrenheit to Celsius
 * 
 */

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		// Input
		
		System.out.print("Enter Degrees in Fahrenheit: ");
		double degreesInFahrenheit = console.nextInt();

		// Process
		
		double degreesInCelsius = .555556 * (degreesInFahrenheit - 32);
		// .555556 is equivalent to 5 / 9 

		// Output
		
		System.out.println("Degrees in Celsius: " + degreesInCelsius);

		console.close();
	}
}
