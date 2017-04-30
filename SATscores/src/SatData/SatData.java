package SatData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * SAT scores helper class.
 * This class provides fairly easy access to the SAT score data. The student
 * should not have to modify this class.
 * usage:
 * 		SatData data = new SatData();
 *      int countOfRecords = data.length;		
		while (data.hasNext()) {
			String state = data.getState();
			int score = data.getCombinedScore();
			etc.
		}

 * @author Jim
 * @date 2014-11-17
 */
public class SatData {
	private boolean trace = false;
	private String fileName = "2013_SAT_scores.txt";
	private File inputFile = null;
	private Scanner fileScanner = null;
	private int rank;
	private String state;
	private String participation;
	private int readingScore;
	private int mathScore;
	private int writingScore;
	private int combinedScore;
	public int length = 51;
	
	/**
	 * @returns false when no more data is available
	 */
	public boolean hasNext() {
		boolean result = false;
		if (inputFile == null) {
			inputFile = new File(fileName);
			if (!inputFile.exists())
			{
				System.out.println("File not found at:" + inputFile.getAbsolutePath());
			    return false;
			} else {
				try {
					fileScanner = new Scanner(inputFile);
				} catch (FileNotFoundException e) {
					System.out.println("Unable to scan file: " + fileName);
					e.printStackTrace();
				}
				if (trace) System.out.println("Opening file of data...");
				for (int i=0; i<3; i++) {
					String s = fileScanner.nextLine();
					if (trace) System.out.println(s);
				}
			}
		}
		
		if (fileScanner.hasNextLine())
		{
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			result = lineScanner.hasNext();
			if (lineScanner.hasNext()) rank = lineScanner.nextInt();
			if (lineScanner.hasNext()) state = lineScanner.next();
			if (lineScanner.hasNext()) participation = lineScanner.next();
			if (lineScanner.hasNext()) readingScore = lineScanner.nextInt();
			if (lineScanner.hasNext()) mathScore = lineScanner.nextInt();
			if (lineScanner.hasNext()) writingScore = lineScanner.nextInt();
			if (lineScanner.hasNext()) combinedScore = lineScanner.nextInt();
			lineScanner.close();
		}
		return result;
	}
	
	/**
	 * @return
	 */
	public int getRank() {
		return rank;
	}
	
	public String getState() {
		return state;
	}
	
	public String getParticipation() {
		return participation;
	}
	
	public int getReadingScore() {
		return readingScore;
	}
	
	public int getMathScore() {
		return mathScore;
	}
	
	public int getWritingScore() {
		return writingScore;
	}
	
	public int getCombinedScore() {
		return combinedScore;
	}
}