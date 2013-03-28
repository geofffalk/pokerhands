package game.cardanalysis;

import game.model.Hand;

import java.util.ArrayList;

/**
 * AbstractAnalyser class is an abstract class that implements the methods for setting, resetting and retrieving 
 * the values for any winning combinations that are found by the visit method. These values are saved in
 * the foundValues field. The visit method is implemented by the individual AbstractAnalyser subclasses
 */
public abstract class AbstractAnalyser implements Analyser {
	private ArrayList<Integer> foundValues; //stores the combinations of winning values 

	/**Constructor, sets the foundValues as an ArrayList
	 */
	public AbstractAnalyser() {
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
