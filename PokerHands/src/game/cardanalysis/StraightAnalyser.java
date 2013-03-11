package game.cardanalysis;

import game.model.Hand;


/**
 * An Analyser class that checks to see whether the cards in a hand form a straight.
 * If so, the highest scoring card is stored in the foundValues field.
 */
public class StraightAnalyser extends Analyser {

	@Override
	public boolean visit(Hand hand) {
		resetFoundValues();
		boolean matchFound = false;
		Integer[] keys = new Integer[hand.getCardTally().size()];
		if (keys.length == 5) {
			keys = (Integer[]) (hand.getCardTally().keySet().toArray(keys));
			if (keys[0] - keys[4] == 4) {
				addFoundValue(keys[0]);
				matchFound = true;
			}
		}
		return matchFound;
	}

}
