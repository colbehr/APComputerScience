/**
 * AP Computer Science, Period 2
 * Project 2 - VisiCalc2015
 * Extra credit so far: 
 * -Help (maybe)
 * @author Colbehr
 * @version March 2015
 * Checkpoint 1, 2, and a little bit of 3
 */
public class blankCell extends Cell {

	protected blankCell(String userInput) {
		super(userInput);
	}

	public String getDisplayValue() {
		return "      ";
	}

}
