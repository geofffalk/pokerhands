package game.model;

public interface Card extends Comparable<Card> {

	/**Checks the suit of a card
	 * @return suit, a string value for the suit of a card
	 */
	public abstract String getSuit();

	/**Checks the value of a card
	 * @return value, an int value for the card number
	 */
	public abstract int getValue();

	/**Sets the value of a card
	 * @param value, an int value for the card number
	 */
	public abstract void setValue(int i);

	public abstract String toString();
	
	public abstract int compareTo(Card o);

}