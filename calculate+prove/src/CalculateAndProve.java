/**
 * 
 * @author Colbehr 
 * assignment Calculate and Prove
 * 
 */
public class CalculateAndProve {
	public static void main(String[] args) {
		//One
		System.out.print("1:  4.0 / 2 * 9 / 2 =  ");
		System.out.print(4.0 / 2 * 9 / 2);
		System.out.println();
		//Two
		System.out.print("2:  12 / 7 * 4.4 * 2 / 4 =  ");
		System.out.print(12 / 7 * 4.4 * 2 / 4);
		System.out.println();
		//Three
		System.out.print("3:  9 / 2.0 + 7 / 3 - 3.0 / 2 =  ");
		System.out.print(9 / 2.0 + 7 / 3 - 3.0 / 2);
		System.out.println();
		//Four
		System.out.print("4:  53 / 5 / (0.6 + 1.4) / 2 + 13 / 2 =  ");
		System.out.print(53 / 5 / (0.6 + 1.4) / 2 + 13 / 2);
		System.out.println();
		//Five
		System.out.print("5:  (238 % 11 + 3) % 7 =  ");
		System.out.print((238 % 11 + 3) % 7);
		System.out.println();
		//Six
		System.out.print("6:  89 % 10 /  4 * 2.0 / 5 + (1.5 + 1.0 / 2) * 2 =  ");
		System.out.print(89 % 10 /  4 * 2.0 / 5 + (1.5 + 1.0 / 2) * 2);
		System.out.println();
		//Seven
		System.out.print("7:  2 + \"(int) 2.0\" + 2 * 2 + 2 =  ");
		// Why?   2 + 2.0 + 4 + 2   =   4.0 + 4 + 2   =   8.0 + 2   =   10.0 
		System.out.print(2 + (int) 2.0 + 2 * 2 + 2);
		System.out.println();

		//Eight
		System.out.print("8:  \"1\" + 2 + 4 + \"4\" + 5 * 6 + \"7\" + (8 + 9) =  ");
		// Why?   1 + 2 + 4 + 4 + 30 + 7 + 17  =  3 + 8 + 30 + 24  =   11 + 30 + 24  =  65
		System.out.print(1 + 2 + 4 + 4 + 5 * 6 + 7 + (8 + 9));
		System.out.println();

	}
}
