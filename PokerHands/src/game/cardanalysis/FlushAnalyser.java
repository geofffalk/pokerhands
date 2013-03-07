package game.cardanalysis;


import game.model.Card;
import game.model.Hand;

import java.util.ArrayList;

/**
 * An Analyser class that checks to see whether all the cards in a hand are the same suit.
 * If so, the highest scoring card is stored in the foundValues field.
 * 
 */
public class FlushAnalyser extends Analyser {


	@Override
	public boolean visit(Hand hand) {
		resetFoundValues(); 
		boolean matchFound = true;
		ArrayList<Card> cards = hand.getCards();
		String suit = "";
		for (Card c : cards) {
			if (suit == "")
				suit = c.getSuit();
			else if (c.getSuit() != suit) {
				matchFound = false;
				break;
			}
			addFoundValue(c.getValue());
		}

		return matchFound;

	}

}
