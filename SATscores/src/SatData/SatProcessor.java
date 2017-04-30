/*
 * @author Colbehr
 * Assignment Sat Processor
 */
package SatData;

public class SatProcessor {

	public static void main(String[] args) {
		SatData data = new SatData();

		String[] stateNames = new String[data.length];
		int[] stateAverage = new int[data.length];
		int[][] subjectScores = new int[data.length][3];
		int counter = 0;
		while (data.hasNext()) {
			stateNames[counter] = data.getState();
			stateAverage[counter] = data.getCombinedScore();
			System.out.printf("State: %-15s  Average score: %5d%n",
					data.getState(), data.getCombinedScore());
			subjectScores[counter][0] = data.getReadingScore();
			subjectScores[counter][1] = data.getMathScore();
			subjectScores[counter][2] = data.getWritingScore();
			counter++;
		}
		average(stateAverage);
		washingtonScore(stateAverage);
		validate(stateAverage, subjectScores);
		System.out.println("No more data");
	}

	public static void average(int[] stateAverage) {
		int totalAverage = 0;
		int count = 0;
		for (@SuppressWarnings("unused")
		int temp : stateAverage) {
			totalAverage += stateAverage[count];
			count++;
		}
		System.out.println("The USA average is: " + (totalAverage / count));
	}

	public static void washingtonScore(int[] stateAverage) {
		SatData data = new SatData();
		int totalScore = 0;
		int washingtonScore = 0;
		while (data.hasNext()) {
			totalScore += data.getCombinedScore();
			if (data.getState().equals("Washington")) {
				washingtonScore = data.getCombinedScore();
			}
		}
		System.out.print("Washington is ");
		if (washingtonScore - (totalScore / data.length) < 0) {
			System.out.print("below average");
		} else {
			System.out.print("above average");
		}
		System.out.println(" by "
				+ (washingtonScore - (totalScore / data.length)));
	}

	public static boolean validate(int[] stateAverage, int[][] subjectScores) {
		int counter = 0;
		boolean validated = true;
		for (int i = subjectScores.length; i > 0; i--) {
			int tempScore = 0;
			for (int j = 2; j >= 0; j--) {
				tempScore = tempScore + subjectScores[counter][j];
			}
			if (tempScore != stateAverage[counter]) {
				validated = false;
				System.out.println("Something isn't right at line " + counter
						+ ".");
			}
			counter++;
		}
		if (validated == true) {
			System.out.println("Scores validated.");
		} else {
			System.out.println("Scores are not validated.");
		}
		return validated;
	}
}

/*
 * This was my old traversing code, while (counter <= subjectScores.length - 1)
 * { tempStore = subjectScores[counter][0] + subjectScores[counter][1] +
 * subjectScores[counter][2]; if (tempStore != stateAverage[counter]) {
 * validated = false; System.out.println("Something isn't right at line " +
 * counter); }
 */