package game.model;


import game.cardanalysis.Analyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class Hand {
	private TreeMap<Integer, Integer> cardTally;
	private ArrayList<Card> cards;

	/**Constructor sets cards arraylist
	 * and cardTally that arranges card according to value
	 */
	public Hand() {
		this.cards = new ArrayList<>();
		this.cardTally = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public TreeMap<Integer, Integer> getCardTally() {
		return cardTally;
	}

	public void addCards(Card[] cs) {
		for (Card c : cs) {
			addCard(c);
		}
		Collections.sort(cards);
	}
	
	/**Adds a card to the hand, and inserts card into cardTally as well 
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
	 */
	public void removeCard(Card c) {
		cards.remove(c);
		int cardValue = c.getValue();
		cardTally.put(cardValue, cardTally.get(cardValue) - 1);
	}

	public String getSuit() {
		return null;
	}
	
	/**Double dispatch Visitor pattern, so Analyser objects can check hand for scoring cobminations
	 * @param Analyser object
	 */
	public boolean analyseMe(Analyser v) {
		return v.visit(this);
	}

	/**Returns the first card found with given value 
	 * @param int value to search for
	 */
	public Card getCardWithValue(int i) {
		for (Card c : cards) {
			if (c.getValue() == i) {
				return c;
			}
		}
		return null;
	}
	
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