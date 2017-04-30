/*
 * @author Colbehr
 * Assignment Dogs Above Average Weight
 * Note: Everything gets a little weird 3/4s of the way though dog above average, sorry if it doesn't make any sense.
 */
import java.util.Arrays;

public class program {

	public static void main(String[] args) {
		double[] DogWeights = { 41.5, 63.2, 56.5, 31.7, 45.2, 26.8, 53.1, 98.1,
				21.0, 21.4, 15.2, 61.2, 38.1, 29.1, 40.2, 41.6, 61.3 };
		TopDogs(DogWeights);
		DogsAboveAverageWeight(DogWeights);
	}

	public static double[] DogsAboveAverageWeight(double[] values) {
		double TotalWeight = 0;
		double AverageWeight = 0;
		for (int i = values.length; i > 0; i--) {
			TotalWeight = TotalWeight + values[i - 1];

		}
		AverageWeight = TotalWeight / values.length;

		Arrays.sort(values);
		int counter = values.length;
		int NumberAboveAverage = 0;
		for (int i = values.length; i > 0; i--) {
			if (values[counter - 1] > AverageWeight) {
				counter--;
				NumberAboveAverage++;
			}
		}
		double[] AboveAverage = new double[NumberAboveAverage];
		// J is sort of another counter.
		int j = 0;
		for (int i = NumberAboveAverage; i > 0; i--) {
			AboveAverage[j] = values[values.length - j - 1];
			j++;
		}
		return AboveAverage;

	}

	public static double[] TopDogs(double[] values) {
		double TotalWeight = 0;
		int HeavyDogsWeight = 0;
		for (int i = values.length; i > 0; i--) {
			TotalWeight = TotalWeight + values[i - 1];

		}
		HeavyDogsWeight = values.length / 2;

		Arrays.sort(values);
		int counter = 0;
		double[] TopDogs = new double[HeavyDogsWeight];
		for (int i = HeavyDogsWeight; i < values.length - 1; i++) {
			TopDogs[counter] = values[values.length - HeavyDogsWeight + counter];
			counter++;
		}
		return TopDogs;

	}
}