package game.cardscoring;

public interface Scorer {
	
	/**Checks the score for a hand
	 * @return int[] scoretable, that will hold a score and values of the cards
	 */
	public int[] getScore();

	/** 
	 * Translates the contents of the hand into something readable.
	 * @return a readable String of the contents of the hand.
	 */
	public String toReadableString();


	/**Compares this object to the specified object
	 * @param scorer, object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is less than, 
	 * equal to, or greater than the specified object.
	 */
	public int compareTo(Scorer scorer);
	
	/** 
	 * Attaches Analyse objects to hand in order to score the hand. Results are stored in scoreTable field.
	 * @return int [] scoretable that will hold a score and values of the cards
	 */
	public int[] calculateScore();
}
