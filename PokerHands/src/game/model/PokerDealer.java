package game.model;

import java.util.Collections;
import java.util.Stack;

public class PokerDealer implements Dealer {
	Stack<Card> pack;//stores the pack of cards
	static PokerDealer instance; //stores a dealing instance

	/**Constructor, sets a new pack
	 */
	private PokerDealer() {
		newPack();
	}

	/* (non-Javadoc)
	 * @see game.model.Dealer#newPack()
	 */
	@Override
	public void newPack() {
		pack = new Stack<Card>();
		String[] suits = new String[] { "hearts", "clubs", "diamonds", "spades" };
		Integer[] values = new Integer[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13,14};
		for (String s : suits) {
			for (Integer v : values) {
				Card c = new PokerCard(v, s);
				pack.add(c);
			}
		}
		shuffle();
	}

	/**Creates a new instance of dealer
	 * @return instance, a new instance of Dealer class
	 */
	public static Dealer getInstance() {
		if (instance == null) {
			instance = new PokerDealer();
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see game.model.Dealer#shuffle()
	 */
	@Override
	public void shuffle() {
		Collections.shuffle(pack);
	}

	/* (non-Javadoc)
	 * @see game.model.Dealer#dealACard()
	 */
	@Override
	public Card dealACard() {
		if (pack.size()<1) {
			newPack();
		}
		return pack.pop();
	}
	
	/**Deals five cards from the top of the stack of cards
	 * @return Card[] an array of 5 cards that will be used for a hand
	 */
	public Card[] dealFiveCards() {
		if (pack.size()<5) {
			newPack();
		}
		return new Card[] {pack.pop(), pack.pop(), pack.pop(), pack.pop(),
							pack.pop() };
	}
}

