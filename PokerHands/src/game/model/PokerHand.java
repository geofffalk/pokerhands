package game.model;


import game.cardanalysis.Analyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**Creates a hand of cards used by players
 */
public class PokerHand implements Hand {
	private TreeMap<Integer, Integer> cardTally;//stores the values of the cards
	private ArrayList<Card> cards;//stores the cards

	/**Constructor sets cards arraylist
	 * and cardTally arranging cards according to value
	 */
	public PokerHand() {
		this.cards = new ArrayList<>();
		this.cardTally = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
	}

	/* (non-Javadoc)
	 * @see game.model.Hand#getCards()
	 */
	@Override
	public ArrayList<Card> getCards() {
		return cards;
	}

	/* (non-Javadoc)
	 * @see game.model.Hand#getCardTally()
	 */
	@Override
	public TreeMap<Integer, Integer> getCardTally() {
		return cardTally;
	}

	/* (non-Javadoc)
	 * @see game.model.Hand#addCards(game.model.PokerCard[])
	 */
	@Override
	public void addCards(Card[] cs) {
		for (Card c : cs) {
			addCard(c);
		}
		Collections.sort(cards);
	}
	
	/* (non-Javadoc)
	 * @see game.model.Hand#addCard(game.model.PokerCard)
	 */
	@Override
	public void addCard(Card c) {
		cards.add(c);
		int cardValue = c.getValue();
		if (cardTally.get(cardValue) == null) {
			cardTally.put(cardValue, 1);
		} else
			cardTally.put(cardValue, cardTally.get(cardValue) + 1);
		Collections.sort(cards);
	}

	/* (non-Javadoc)
	 * @see game.model.Hand#removeCard(game.model.Card)
	 */
	@Override
	public void removeCard(Card c) {
		cards.remove(c);
		int cardValue = c.getValue();
		cardTally.put(cardValue, cardTally.get(cardValue) - 1);
	}
	
	/* (non-Javadoc)
	 * @see game.model.Hand#analyseMe(game.cardanalysis.Analyser)
	 */
	@Override
	public boolean analyseMe(Analyser v) {
		return v.visit(this);
	}

	/* (non-Javadoc)
	 * @see game.model.Hand#getCardWithValue(int)
	 */
	@Override
	public Card getCardWithValue(int i) {
		for (Card c : cards) {
			if (c.getValue() == i) {
				return c;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see game.model.Hand#getCardAtPosition(int)
	 */
	@Override
	public Card getCardAtPosition(int i) {
		return cards.get(i);
	}
	
	
	/* (non-Javadoc)
	 * @see game.model.Hand#toStringArray()
	 */
	@Override
	public String[] toStringArray() {
		String[] handList = new String[5];
		int index=1;
		for (Card c : cards) {
			handList[index-1] = (index++ + ": " + c.toString() + "\n");
		}
		return handList;
	}
}