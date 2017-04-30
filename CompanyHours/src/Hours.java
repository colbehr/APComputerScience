/*
 * @author Colbehr
 * Assignment:  Hours
 */
import java.io.*;
import java.util.Scanner;

public class Hours {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("Hours.dat"));
		double companytotal = 0;
		while (input.hasNextLine()) {
			String line1 = input.nextLine();
			Scanner line = new Scanner(line1);
			int workernum = line.nextInt();
			String workername = line.next();
			System.out.printf("%-4s (ID# %d)",
					workername, workernum);
			int days = 0;
			double workertotal = 0;
			double workeraverage = 0;
			while (line.hasNextDouble()) {
				double hour = line.nextDouble();
				workertotal = workertotal + hour;
				days++;
				companytotal = companytotal + workertotal;
			}
			workeraverage = workertotal/days;
			System.out.printf(" Worked %.1f hours (%.1f Hours/Day) ", workertotal, workeraverage);
			System.out.println();
			line.close();
		}
		input.close();
		double companyaverage = companytotal / 5;
		System.out.println();
		System.out.printf("Total/Average Hours worked by all employees: %.1f / %.1f", companytotal, companyaverage);
		//wasn't sure if that meant average per employee or company average.
	}

}
