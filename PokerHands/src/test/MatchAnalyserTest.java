package test;

import static org.junit.Assert.*;
import game.cardanalysis.Analyser;
import game.cardanalysis.MatchAnalyser;
import game.model.Hand;
import game.model.PokerCard;
import game.model.PokerHand;

import org.junit.Test;


public class MatchAnalyserTest {

	PokerCard c1;
	PokerCard c2;
	PokerCard c3;
	PokerCard c4;
	PokerCard c5;
	Hand hand;


	@Test
	public void test() {
		c1 = new PokerCard(2, "diamonds");
		c2 = new PokerCard(2, "spades");
		c3 = new PokerCard(12, "clubs");
		c4 = new PokerCard(12, "hearts");
		c5 = new PokerCard(12, "spades");
		hand = new PokerHand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Analyser matchAnalyser = new MatchAnalyser(2);
		boolean expectedResult = true;
		boolean actualResult = hand.analyseMe(matchAnalyser);
		assertEquals("Wrong", expectedResult, actualResult);

	}

	@Test
	public void test2() {
		c1 = new PokerCard(2, "diamonds");
		c2 = new PokerCard(2, "spades");
		c3 = new PokerCard(12, "clubs");
		c4 = new PokerCard(12, "hearts");
		c5 = new PokerCard(12, "spades");
		hand = new PokerHand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		MatchAnalyser matchAnalyser = new MatchAnalyser(3);
		hand.analyseMe(matchAnalyser);
		int expectedResult = 12;
		int actualResult = matchAnalyser.getFoundValues().get(0);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void test3() {
		c1 = new PokerCard(2, "diamonds");
		c2 = new PokerCard(2, "spades");
		c3 = new PokerCard(12, "clubs");
		c4 = new PokerCard(12, "hearts");
		c5 = new PokerCard(12, "spades");
		hand = new PokerHand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Analyser matchAnalyser = new MatchAnalyser(3);
		boolean expectedResult = true;
		boolean actualResult = hand.analyseMe(matchAnalyser);
		assertEquals("Wrong", expectedResult, actualResult);

	}

}
