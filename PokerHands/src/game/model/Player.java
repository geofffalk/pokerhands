package game.model;

public interface Player {

	/**Checks which cards should be kept
	 * @param scoreCard,  given int arraylist which includes an overall score for the cards and values of the cards
	 * @return int[], indexes of cards that will be discarded
	 */
	public int[] selectCardValuesToThrow(int[] scoreCard);

}
