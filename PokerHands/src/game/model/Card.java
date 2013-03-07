package game.model;


public class Card implements Comparable<Card> {
	private String suit;//suit of a card
	private Integer cardValue;//value of a card
	private String[] valueNames;//strings for the values of the cards

	/**A constructor that sets the value and suit of a card 
	 * @param v given value for a card
	 * @param s given suit of a card
	 */
	public Card(int v, String s) {
		if (s.equals("spades") || s.equals("diamonds") || s.equals("clubs")
				|| s.equals("hearts")) {
			this.setSuit(s);
		}
		if (v > 1 && v < 15) {
			this.setValue(v);
		}
		valueNames = new String[] { "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

	}
	
	/**Sets the suit of a card
	 * @param s, a string value for the suit of a card
	 */
	private void setSuit(String s) {
		this.suit = s;

	}

	/**Checks the suit of a card
	 * @return suit, a string value for the suit of a card
	 */
	public String getSuit() {
		return suit;
	}

	/**Checks the value of a card
	 * @return value, an int value for the card number
	 */
	public int getValue() {
		return cardValue;
	}

	/**Sets the value of a card
	 * @param value, an int value for the card number
	 */
	public void setValue(int i) {
		cardValue = i;
	}

	public String toString() {
		return valueNames[getValue()- 2]  + " of " + getSuit();
	}

	
	@Override
	public int compareTo(Card o) {
		int compareValue = ((Card) o).getValue();
		return this.getValue() - compareValue;
	}

}
