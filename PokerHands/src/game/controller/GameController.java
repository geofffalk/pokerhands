package game.controller;

import game.cardscoring.HandScorer;
import game.cardscoring.Scorer;
import game.model.Card;
import game.model.ComputerPlayer;
import game.model.Dealer;
import game.model.Hand;
import game.model.Player;
import game.view.GameDisplay;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {
	GameDisplay display;
	Dealer dealer;
	Hand computerHand;
	Hand humanHand;
	Scorer computerScore;
	Scorer humanScore;

	public GameController() {
		display = new GameDisplay();
		dealer = Dealer.getInstance();
		computerHand = new Hand();
		humanHand = new Hand();
		display.getObservable().addObserver(this);
	}

	public void begin() {
		humanHand.addCards(dealer.dealFiveCards());
		computerHand.addCards(dealer.dealFiveCards());
		display.showFirstHand("Human", humanHand);
		display.waitForUserDecision();
	}

	private void startComputerRound() {
		display.showFirstHand("Computer", computerHand);
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
		display.showSecondHand("Computer", computerHand);
		computerScore = new HandScorer(computerHand);
		display.showScore("Computer", computerScore);
		showWinner();
	}

	private void exchangeCards(ArrayList<Card> cards, Hand h) {
		if (cards.size() == 0)
			display.showNoCardExchange();
		else {
			for (Card c : cards) {
				display.showCardExchange(c);
				h.removeCard(c);
				h.addCard(dealer.dealACard());
			}
		}
	}

	private void showWinner() {
		if (computerScore.compareTo(humanScore) > 0)
			display.showWinner("Computer");
		else if (computerScore.compareTo(humanScore) < 0)
			display.showWinner("Human");
		else
			display.showWinner("Nobody");

	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof int[]) {
			ArrayList<Card> cardsToExchange = new ArrayList<>();
			for (int i = 0; i < ((int[]) arg).length; i++) {
				cardsToExchange.add(humanHand
						.getCardAtPosition(((int[]) arg)[i] - 1));
			}
			exchangeCards(cardsToExchange, humanHand);
			display.showSecondHand("Human", humanHand);
			humanScore = new HandScorer(humanHand);
			display.showScore("Human", humanScore);
			startComputerRound();
		}
	}
}
