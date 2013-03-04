package game.view;

import game.cardscoring.Scorer;
import game.model.Card;
import game.model.Hand;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameDisplay {

	private DelegatedObservable obs;

	public GameDisplay() {
		this.obs = new DelegatedObservable();
	}

	public void showFirstHand(String player, Hand h) {


		System.out.println("\n******************************************");
		System.out.println(player + " has been dealt this hand:");
		System.out.print("\n");
		System.out.println(h.toString());
		System.out.println("******************************************");

	}

	public void showCardExchange(Card c) {
		System.out.println("Exchanging '" + c.toString() + "'\n");

	}

	public void showScore(String player, Scorer handScorer) {
		System.out.println("****" + player + " Score*********************\n");
		System.out.println(player + "'s " + handScorer.toReadableString()
				+ "\n");
	}

	public void beginRound(String string) {
		System.out.println(string + "'s hand:\n");
	}

	public void showSecondHand(String player, Hand h) {

		System.out.println(player + "'s final hand:");
		System.out.print("\n");
		System.out.println(h.toString());

	}

	public void showWinner(String string) {
		System.out.println("******************************************");
		System.out.println(string + " is the winner!!");
		System.out.println("******************************************");

	}

	public void showNoCardExchange() {
		System.out.println("No cards are exchanged");

	}

	public DelegatedObservable getObservable() {
		return obs;
	}

	public void waitForUserDecision() {
		boolean error_input = false;
		Scanner user_input = new Scanner(System.in);
		System.out
				.println("Please enter the cards you wish to exchange - for example: 1,3 for the first and third card");
		String input = user_input.nextLine();
		Set<Integer> numberSet = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				int val = Character.getNumericValue(input.charAt(i));
				if (val > 0 && val < 6) {
					numberSet.add(val);
				} else {
					error_input = true;
					break;
				}
			}
		}
		if (error_input) {
			System.out.println("Incorrect input!");
			waitForUserDecision();
		} else {
			int[] output = new int[numberSet.size()];
			int index = 0;
			for (Integer in : numberSet) {
				output[index++] = in;
			}
			user_input.close();
			obs.setChanged();
			obs.notifyObservers(output);
		}

	}



}
