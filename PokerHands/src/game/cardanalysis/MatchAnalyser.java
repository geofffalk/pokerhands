package game.cardanalysis;


import game.model.Hand;

import java.util.Iterator;
/**
 * An Analyser class that checks whether there are singles, pairs, triples or pokers in a hand.
 * If so, the values of the combinations are stored in the foundValues field.
 * 
 */
public class MatchAnalyser extends Analyser {
	
	private int numberOfCardsToMatch; //stores number of cards to be matched (example 2 - will check for a pair)
	
	/**Constructor, sets foundValues and number of cards to match
	 * @param c, number of cards that will be checked for (example 2 - will check for a pair)
	 */
	public MatchAnalyser(int c) {
		super();
		this.numberOfCardsToMatch = c;
	}


	@Override
	public boolean visit(Hand hand) {
		resetFoundValues();
		boolean matchFound = false;
		Iterator<Integer> it = hand.getCardTally().keySet().iterator();
		while (it.hasNext()) {
			int key = it.next();
			if (hand.getCardTally().get(key) == numberOfCardsToMatch) {
				addFoundValue(key);
				matchFound = true;
			}
		}
		return matchFound;

	}


}
