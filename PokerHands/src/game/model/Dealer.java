package game.model;

public interface Dealer {

	/**Creates a new stack of cards with all cards and shuffles the cards
	 */
	public abstract void newPack();

	/**Shuffles the pack of cards into a random order
	 */
	public abstract void shuffle();

	/**Deals a card from the top of the stack of cards
	 * @return a card from the top of the pack
	 */
	public abstract Card dealACard();
	
	public abstract Card[] dealFiveCards();

}