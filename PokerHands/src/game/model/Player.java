package game.model;

/**Provides Guidelines of methods for player classes (example Computer player)
 */
public interface Player {

	/**Checks which cards should be kept
	 * @param scoreCard,  a given int arraylist which includes an overall score for the cards along with the values of the cards
	 * @return int[], indexes of the cards to be discarded
	 */
	public int[] selectCardValuesToThrow(int[] scoreCard);

}
