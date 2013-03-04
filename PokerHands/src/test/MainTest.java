package test;

//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import code.Card;
//import code.ComputerPlayer;
//import code.Dealer;
//import code.Hand;
//import code.HandScorer;
//import code.Player;
//import code.Scorer;

public class MainTest {

//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@Test
//	public void humanTest() {
//		Dealer dealer = Dealer.getInstance();
//		Hand hand1 = new Hand();
//		hand1.addCards(dealer.dealFiveCards());
//		System.out.println("Dealer dealing you five cards:\n");
//		System.out.println(hand1.toString());
//		Scanner user_input = new Scanner(System.in);
//		System.out
//				.println("Please enter the cards you wish to exchange - for example: 1,3 for the first and third card");
//		String input = user_input.nextLine();
//		ArrayList<Card> list = new ArrayList<>();
//		for (int i = 0; i < input.length(); i++) {
//			if (Character.isDigit(input.charAt(i))) {
//				list.add(hand1.getCardAtPosition(Character
//						.getNumericValue(input.charAt(i) - 1)));
//			}
//		}
//		user_input.close();  
//		for (Card c : list) {
//			System.out.println("Exchanging '"+c.toString()+"'\n");
//			hand1.removeCard(c);
//			hand1.addCard(dealer.dealACard());
//		}
//		System.out.println("Your final hand is:\n");
//		System.out.println(hand1.toString()+"\n");
//		Scorer handScorer = new HandScorer(hand1);
//		System.out.println(handScorer.toReadableString()+"\n\n");
//
//	}
//
//	@Test
//	public void computerTest() { 
//		Dealer dealer = Dealer.getInstance();
//		Hand hand1 = new Hand();
//		hand1.addCards(dealer.dealFiveCards());
//		System.out.println("Computer's hand:\n");
//		System.out.println(hand1.toString());
//		Scorer handScorer = new HandScorer(hand1);
//		int[] score = handScorer.getScore();
//		//System.out.println("Computer's score " + handScorer.toString());
//		Player computerPlayer = new ComputerPlayer();
//		int[] valuesToThrow = computerPlayer.selectCardValuesToThrow(score);
//	//	System.out.println("Computer is exchanging these cards: "+ Arrays.toString(valuesToThrow));
//		ArrayList<Card> list = new ArrayList<>();
//		for (int i = 0; i < valuesToThrow.length; i++) {
//			if (valuesToThrow[i] != 0)
//				list.add(hand1.getCardWithValue(valuesToThrow[i]));
//		}
//		for (Card c : list) {
//			System.out.println("Exchanging '"+c.toString()+"'\n");
//			hand1.removeCard(c);
//			hand1.addCard(dealer.dealACard());
//		}
//		System.out.println("Computer's final hand is:\n");
//		System.out.println(hand1.toString());
//		handScorer = new HandScorer(hand1);
//		System.out.println(handScorer.toReadableString());
//
//	}

}
