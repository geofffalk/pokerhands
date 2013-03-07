package game.model;


import game.cardanalysis.Analyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class Hand {
	private TreeMap<Integer, Integer> cardTally;//stores the values of the cards
	private ArrayList<Card> cards;//stores the cards

	/**Constructor sets cards arraylist
	 * and cardTally arranging cards according to value
	 */
	public Hand() {
		this.cards = new ArrayList<>();
		this.cardTally = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
	}

	/**Gets the cards
	 * @return cards, an ArrayList of cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

	/**Gets the TreeMap
	 * @return cardTally, a tree map of card values
	 */
	public TreeMap<Integer, Integer> getCardTally() {
		return cardTally;
	}

	/**Adds an arraylist of cards and then sorts the cards
	 * @param cs, given arraylist of cards
	 */
	public void addCards(Card[] cs) {
		for (Card c : cs) {
			addCard(c);
		}
		Collections.sort(cards);
	}
	
	/**Adds a card to the hand, and inserts card into cardTally as well 
	 * @param c, given card
	 */
	public void addCard(Card c) {
		cards.add(c);
		int cardValue = c.getValue();
		if (cardTally.get(cardValue) == null) {
			cardTally.put(cardValue, 1);
		} else
			cardTally.put(cardValue, cardTally.get(cardValue) + 1);
		Collections.sort(cards);
	}

	/**Removes card from hand, and adjusts cardTally also 
	 * @param c, given card that will be removed
	 */
	public void removeCard(Card c) {
		cards.remove(c);
		int cardValue = c.getValue();
		cardTally.put(cardValue, cardTally.get(cardValue) - 1);
	}
	
	/**Double dispatch Visitor pattern, so Analyser objects can check hand for scoring combinations
	 * @param v, Analyser object
	 * @return a boolean used to indicate if the visited object has a certain status
	 */
	public boolean analyseMe(Analyser v) {
		return v.visit(this);
	}

	/**Returns the first card found with given value 
	 * @param i, int value to search for
	 * @return c, card with the given value
	 */
	public Card getCardWithValue(int i) {
		for (Card c : cards) {
			if (c.getValue() == i) {
				return c;
			}
		}
		return null;
	}
	
	/**Returns the card found at a given position in the arraylist
	 * @param i, int position to search for
	 * @return card at the given position
	 */
	public Card getCardAtPosition(int i) {
		return cards.get(i);
	}
	
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		int index=1;
		for (Card c : cards) {
			output.append(index++ + ": " + c.toString() + "\n");
		}
		return output.toString();
	}
}