//some stuff happens here...
/**
 * AP Computer Science, Period 2
 * Project 2 - VisiCalc2015
 * Extra credit so far: 
 * -Help (maybe)
 * @author Colbehr
 * @version March 2015
 * Checkpoint 1, 2, and a little bit of 3
 */
public class Cell {
	public String userInput;

	protected Cell(String userInput) {
		this.userInput = userInput;
	}

	public void setDisplayValue(String string) {
		userInput = string;
	}

	public String toString() {
		return userInput;
	}
}
