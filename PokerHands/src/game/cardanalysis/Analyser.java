package game.cardanalysis;

import game.model.Hand;

import java.util.ArrayList;

public interface Analyser {


	/**Visit a hand and analyse it for specific combination, using the Visitor design pattern. If card combination is found, return true, else return false
	 * @param hand, to be analysed 
	 * @return boolean, indicating whether a pattern has been found
	 */
	public boolean visit(Hand hand);
	

	/**If a pattern is found, record the value of the card related to that pattern
	 * @param i, the given value of a card
	 */
	public void addFoundValue(Integer i);
	
	
	/**Reset the found values
	 *
	 */
	public void resetFoundValues();
	
	
	/**Return the found values
	 *
	 */
	public ArrayList<Integer> getFoundValues();


}
