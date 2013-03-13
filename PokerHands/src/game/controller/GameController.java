package game.controller;

import game.cardscoring.HandScorer;
import game.cardscoring.Scorer;
import game.model.Card;
import game.model.ComputerPlayer;
import game.model.Dealer;
import game.model.Hand;
import game.model.Player;
import game.view.DelegatedObservable;
import game.view.playerDisplay;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**Acts as a controller for MVC pattern
 */
public class GameController implements Observer {
	Dealer dealer;//stores an instance of dealer
	playerDisplay computerDisplay; //display for computerPlayer
	playerDisplay humanDisplay; //display for humanPlayer
	Hand computerHand;//computer's hand 
	Hand humanHand;//human's hand
	Scorer computerScore;//computer's score
	Scorer humanScore;//human's score
	boolean exchangeCards = false;

	/**Initializes variables and adds an observer allowing this class to observe the display class  
	 * @param gDisplay, given display
	 */
	public GameController(playerDisplay gHumanDisplay, playerDisplay gComputerDisplay) {
		dealer = Dealer.getInstance();
		computerDisplay = gComputerDisplay;
		humanDisplay = gHumanDisplay;
		computerHand = new Hand();
		humanHand = new Hand();
		humanDisplay.getObservable().addObserver(this);
	}


	/**Carries out first few steps of playing a game
	 */
	public void begin() {
		humanHand.addCards(dealer.dealFiveCards());
		computerHand.addCards(dealer.dealFiveCards());
		humanDisplay.showFirstHand("Human", humanHand);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof int[]) {
			ArrayList<Card> cardsToExchange = new ArrayList<>();
			for (int i = 0; i < ((int[]) arg).length; i++) {
				cardsToExchange.add(humanHand
						.getCardAtPosition(((int[]) arg)[i]));
			}
			exchangeCards(cardsToExchange, humanHand);
			humanDisplay.showExchange(exchangeCards, cardsToExchange, computerHand);
			humanDisplay.showSecondHand("Human", humanHand);
			humanScore = new HandScorer(humanHand);
			humanDisplay.showScore("Human", humanScore);
			startComputerRound();
		}
	}

		

	/** Carries out remaining actions for the game 
	 *  once human has played
	 */
	private void startComputerRound() {
		computerDisplay.setVisible(true);
		computerDisplay.showFirstHand("Computer", computerHand);
		computerScore = new HandScorer(computerHand);
		int[] score = computerScore.getScore();
		Player computerPlayer = new ComputerPlayer();
		int[] valuesToThrow = computerPlayer.selectCardValuesToThrow(score);
		ArrayList<Card> cardsToExchange = new ArrayList<>();
		for (int i = 0; i < valuesToThrow.length; i++) {
			if (valuesToThrow[i] != 0)
				cardsToExchange.add(computerHand
						.getCardWithValue(valuesToThrow[i]));
		}
		exchangeCards(cardsToExchange, computerHand);
		computerDisplay.showExchange(exchangeCards, cardsToExchange, computerHand);
		computerDisplay.showSecondHand("Computer", computerHand);
		computerScore= new HandScorer(computerHand);
		computerDisplay.showScore("Computer", computerScore);
		showWinner();
	}

	/**Exchanges cards 
	 * @param cards, the given cards to be exchanged
	 * @param h, the given hand
	 */
	private void exchangeCards(ArrayList<Card> cards, Hand h) {
		if (cards.size() == 0)
			exchangeCards = false;
		else {
			for (Card c : cards) {
				exchangeCards = true;
				h.removeCard(c);
				h.addCard(dealer.dealACard());
			}
		}
	}

	/**Checks who is the winner by comparing scores
	 */
	private void showWinner() {
		if (computerScore.compareTo(humanScore) > 0)
			computerDisplay.showWinner("Computer");
		else if (computerScore.compareTo(humanScore) < 0)
			humanDisplay.showWinner("Human");
		else
			humanDisplay.showWinner("Nobody");

	}
	
}
