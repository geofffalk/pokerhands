package game.cardscoring;


import game.cardanalysis.Analyser;
import game.cardanalysis.FlushAnalyser;
import game.cardanalysis.MatchAnalyser;
import game.cardanalysis.StraightAnalyser;
import game.model.Hand;

/**HandScorer aggregates the results of the various Analyser objects into the scoreTable field,
 * scoreTable[0] shows the main combination found,
 * and is as follows:
 * 50 Straight flush
 * 45 Poker (four of a kind)
 * 40 Full house
 * 36 Flush
 * 33 Straight
 * 30 Three of a kind
 * 20 Two pairs
 * 10 Pair
 * 1 Single
 * scoreTable[1] contains the card value of the winning card/combination.
 * scoreTable[2]-scoreTable[5] contains the value of the remaining cards, from highest to lowest
 */
public class HandScorer implements Scorer, Comparable<Scorer> {
	private Hand hand;
	private int[] scoreTable;
	boolean hasPoker, hasStraight, hasFlush, hasThreeOfAKind, hasPair;
	int numOfPairs;

	/** HandScorer constructor
	 *@param Hand object that is to be analysed
	 */
	public HandScorer(Hand h) {
		this.hand = h;
		scoreTable = new int[6];
		calculateScore();
	}

	public int[] getScore() {
		return scoreTable;
	}

	public int[] calculateScore() {
		Analyser testForPoker = new MatchAnalyser(4);
		Analyser testForFlush = new FlushAnalyser();
		Analyser testForStraight = new StraightAnalyser();
		Analyser testForThreeOfAKind = new MatchAnalyser(3);
		Analyser testForPair = new MatchAnalyser(2);
		Analyser testForSingle = new MatchAnalyser(1);
		hasPoker = hand.analyseMe(testForPoker);
		hasStraight = hand.analyseMe(testForStraight);
		hasFlush = hand.analyseMe(testForFlush);
		hasThreeOfAKind = hand.analyseMe(testForThreeOfAKind);
		hasPair = hand.analyseMe(testForPair);
		hand.analyseMe(testForSingle);

		// Test for Straight Flush
		if (hasStraight && hasFlush) {
			scoreTable[0] = 50;
		}
		// Test for Poker
		else if (hasPoker) {
			scoreTable[0] = 45;
			scoreTable[1] = testForPoker.getFoundValues().get(0);
		}
		// Test for full house
		else if (hasThreeOfAKind && hasPair) {
			scoreTable[0] = 40;
			scoreTable[1] = testForThreeOfAKind.getFoundValues().get(0);
			scoreTable[2] = testForPair.getFoundValues().get(0);
		}
		// Test for flush
		else if (hand.analyseMe(testForFlush)) {
			scoreTable[0] = 36;
		}
		// Test for straight
		else if (hand.analyseMe(testForStraight)) {
			scoreTable[0] = 33;
		}
		// Test for three of a kind
		else if (hasThreeOfAKind) {
			scoreTable[0] = 30;
			scoreTable[1] = testForThreeOfAKind.getFoundValues().get(0);
		}
		// Test for pairs
		else if (hasPair) {
			numOfPairs = testForPair.getFoundValues().size();
			scoreTable[0] = (numOfPairs == 2) ? 20 : 10;
			scoreTable[1] = testForPair.getFoundValues().get(0);
			scoreTable[2] = (numOfPairs == 2) ? testForPair.getFoundValues()
					.get(1) : 0;
		}
		// Test for single
		else {
			scoreTable[0] = 1;
		}
		// Populate remainder of scoreTable with scores for single cards
		int counter = -1;
		do {
			counter++;
		} while (scoreTable[counter] > 0);
		for (int i : testForSingle.getFoundValues()) {
			scoreTable[counter] = i;
			counter++;
		}
		return scoreTable;
	}

	@Override
	public int compareTo(Scorer o) {

		for (int i = 0; i < scoreTable.length; i++) {
			if (this.getScore()[i] > o.getScore()[i]) {
				return 1;
			}
			else if (this.getScore()[i] < o.getScore()[i]) {
				return -1;
			}
		}
		return 0;
	}


	public String toString() {
		String[] valueNames = new String[] { "Twos", "Threes", "Fours", "Fives",
				"Sixes", "Sevens", "Eights", "Nines", "Tens", "Jacks", "Queens", "Kings", "Aces" };
		String firstCard = valueNames[scoreTable[1]-2];
		String secondCard = valueNames[scoreTable[2]-2];
		StringBuilder sb = new StringBuilder("hand contains ");
		if (hasPoker) {
			sb.append("a POKER of "+firstCard+".");
		} else if (hasStraight) {
			sb.append("a STRAIGHT with "+firstCard + " high.");
		} else if (hasFlush) {
			sb.append("a FLUSH.");
		} else if (hasThreeOfAKind && hasPair) {
			sb.append("a FULL HOUSE.");
		} else if (hasThreeOfAKind) {
			sb.append("three "+firstCard+".");
		} else if (hasPair && numOfPairs==2) {
			sb.append("a pair of "+firstCard+" and a pair of "+secondCard+".");
		} else if (hasPair) {
			sb.append("a pair of "+firstCard+".");
		} else {
			sb.append("a "+((scoreTable[1]==6)?"Six" : firstCard.substring(0,firstCard.length()-1) + " high."));
		}
		return sb.toString();
	}


}
