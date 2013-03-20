package game.model;

import game.cardanalysis.Analyser;

import java.util.ArrayList;
import java.util.TreeMap;

public interface Hand {

	/**Gets the cards
	 * @return cards, an ArrayList of cards
	 */
	public abstract ArrayList<Card> getCards();

	/**Gets the TreeMap
	 * @return cardTally, a tree map of card values
	 */
	public abstract TreeMap<Integer, Integer> getCardTally();

	/**Adds an arraylist of cards and then sorts the cards
	 * @param cs, given arraylist of cards
	 */
	public abstract void addCards(Card[] cs);

	/**Adds a card to the hand, and inserts card into cardTally as well 
	 * @param c, given card
	 */
	public abstract void addCard(Card c);

	/**Removes card from hand, and adjusts cardTally also 
	 * @param c, given card that will be removed
	 */
	public abstract void removeCard(Card c);

	/**Double dispatch Visitor pattern, so Analyser objects can check hand for scoring combinations
	 * @param v, Analyser object
	 * @return a boolean used to indicate if the visited object has a certain status
	 */
	public abstract boolean analyseMe(Analyser v);

	/**Returns the first card found with given value 
	 * @param i, int value to search for
	 * @return c, card with the given value
	 */
	public abstract Card getCardWithValue(int i);

	/**Returns the card found at a given position in the arraylist
	 * @param i, int position to search for
	 * @return card at the given position
	 */
	public abstract Card getCardAtPosition(int i);

	/**Makes a String array of the Hand, this used to populate the JList on the display panel
	 * @return handList, an array of the card names plus an extra option not to exchange cards
	 */
	public abstract String[] toStringArray();

}