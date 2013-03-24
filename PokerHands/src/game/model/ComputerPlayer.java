package game.model;


/**Creates a computer player object that can decide which cards to discard
 */
public class ComputerPlayer implements Player {

	/* (non-Javadoc)
	 * @see game.model.Player#selectCardValuesToThrow(int[])
	 */
	@Override
	public int[] selectCardValuesToThrow(int[] scoreCard) {
		int[] output = new int[5];//cards that will be discarded
		
		if (scoreCard[0] == 45) {
			// poker detected - swap extra card if it's below value of 10
			if (scoreCard[2] < 10)
				output[0] = scoreCard[2];
		} else if (scoreCard[0] >= 33) {
			// straight, flush or full house detected. Don't change a thing!
		} else if (scoreCard[0] == 30) {
			// three of a kind detected. Throw two cards
			output[0] = scoreCard[2];
			output[1] = scoreCard[3];
		} else if (scoreCard[0] == 20) {
			// two pairs detected. Throw one card
			output[0] = scoreCard[3];
		} else if (scoreCard[0] == 10) {
			// one pair detected. Throw two or three cards, depending on value
			// of highest card
			output[0] = (scoreCard[2] > 10) ? 0 : scoreCard[2];
			output[1] = scoreCard[3];
			output[2] = scoreCard[4];
		} else {
			// nothing detected.Throw five, four or three cards, depending
			// on their value
			output[0] = (scoreCard[1] > 10) ? 0 : scoreCard[1];
			output[1] = (scoreCard[2] > 10) ? 0 : scoreCard[2];
			output[2] = scoreCard[3];
			output[3] = scoreCard[4];
			output[4] = scoreCard[5];
		}
		return output;
	}

}
