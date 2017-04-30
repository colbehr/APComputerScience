import java.util.Arrays;

public class Sort2 {

	public static void main(String[] args) {
		
		int[] data = { 1, 16, 5, -2, 8, 8, 9, 0, 13, 20 };
		System.out.println("Before: " + Arrays.toString(data));
		int iterations = selectionSort(data);
		System.out.println("After : " + Arrays.toString(data));
		System.out.printf("Selection sort took %d iterations.%n", iterations);
	}

	/**
	 * selectionSort accepts an unsorted array of integers, sorts the data in
	 * the array and returns a count of iterations required to perform the sort.
	 * 
	 * @param data
	 *            - array of ints
	 * @return iteration count
	 */
	private static int selectionSort(int[] data) {
		int iterations = 0;
		int curNum = 0;
		int smallestNum = 0;
		int pointer = 1;
		int temp = 0;
		int counter = 0;
		while (true) {
			if (data[pointer] < data[curNum]) {
//				temp = data[pointer];
//				data[pointer] = data[curNum];
//				data[curNum] = temp;
				iterations++;
//				if (pointer == data.length) {
//					pointer = curNum + 1;
//				} else {
//					pointer++;
//				}
				smallestNum = data[pointer];
				counter = 0;
			} else {
				
				if (pointer == data.length) {
					pointer = curNum + 1;
				}else {
					pointer++;
				}
				counter++;
				if (counter == data.length + 1) {
					break;
				}
			}
		}
		return iterations;
	}
}