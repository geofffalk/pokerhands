package game.model;


/**Creates card objects
 */
public class PokerCard implements Card {
	private String suit;//suit of a card
	private Integer cardValue;//value of a card
	private String[] valueNames;//strings for the values of the cards

	/**A constructor that sets the value and suit of a card 
	 * @param v given value for a card
	 * @param s given suit of a card
	 */
	public PokerCard(int v, String s) {
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

	/* (non-Javadoc)
	 * @see game.model.Card#getSuit()
	 */
	@Override
	public String getSuit() {
		return suit;
	}

	/* (non-Javadoc)
	 * @see game.model.Card#getValue()
	 */
	@Override
	public int getValue() {
		return cardValue;
	}

	/* (non-Javadoc)
	 * @see game.model.Card#setValue(int)
	 */
	@Override
	public void setValue(int i) {
		cardValue = i;
	}

	
	/* (non-Javadoc)
	 * @see game.model.Card#toString()
	 */
	@Override
	public String toString() {
		return valueNames[getValue()- 2]  + " of " + getSuit();
	}

	
	/* (non-Javadoc)
	 * @see game.model.Card#compareTo(game.model.PokerCard)
	 */

	@Override
	public int compareTo(Card o) {
		int compareValue = ((Card) o).getValue();
		return this.getValue() - compareValue;
	}

}
