package game.cardanalysis;

import game.model.Hand;

import java.util.ArrayList;

/**
 * Analyser class is an abstract class that is responsible for visiting a hand and scanning for
 * winning combinations. The value of the combination is stored in the
 * foundValues field.
 * 
 */
public abstract class Analyser {
	private ArrayList<Integer> foundValues; //stores the combinations of winning values 

	/**Constructor, sets the foundValues
	 */
	public Analyser() {
		foundValues = new ArrayList<>();
	}

	/**Resets foundValues to null
	 */
	public void resetFoundValues() {
		foundValues = null;
		foundValues = new ArrayList<>();
	}

	/**Checks the foundValues
	 * @return foundValues, combinations of winning values
	 */
	public ArrayList<Integer> getFoundValues() {
		return foundValues;
	}

	/**Adds a value to foundValues
	 * @param i, a given value of a card
	 */
	public void addFoundValue(Integer i) {
		this.foundValues.add(i);
	}


	/**Visits a hand and analyses it accordingly
	 * @param hand, to be anaylsed 
	 * @return boolean, indicating the status of the card
	 */
	public abstract boolean visit(Hand hand);

}
