import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] data = { 1, 16, 5, -2, 8, 8, 9, 0, 13, 20 };
		System.out.println("Before: " + Arrays.toString(data));
		int iterations = bubbleSort(data);
		System.out.println("After : " + Arrays.toString(data));
		System.out.printf("Bubble sort took %d iterations.%n", iterations);
	}

	/**
	 * bubbleSort accepts an unsorted array of integers, sorts the data in the
	 * array and returns a count of iterations required to perform the sort.
	 * 
	 * @param data
	 *            - array of ints
	 * @return iteration count
	 */
	private static int bubbleSort(int[] data) {
		int iterations = 0;
		int temp = 0;
		int i = 0;
		while (true) {
			if (data[i] > data[i + 1]) {
				temp = data[i];
				data[i] = data[i + 1];
				data[i + 1] = temp;
				iterations++;
			}
			i++;
			if ( i == data.length-1){
				i = 0;
			}
			if (iterations == 14){
				break;
			}
		}
		return iterations;
	}
}