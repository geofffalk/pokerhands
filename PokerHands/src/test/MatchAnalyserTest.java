package test;

import static org.junit.Assert.*;
import game.cardanalysis.Analyser;
import game.cardanalysis.MatchAnalyser;
import game.model.Card;
import game.model.Hand;

import org.junit.Test;


public class MatchAnalyserTest {

	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card c5;
	Hand hand;


	@Test
	public void test() {
		c1 = new Card(2, "diamonds");
		c2 = new Card(2, "spades");
		c3 = new Card(12, "clubs");
		c4 = new Card(12, "hearts");
		c5 = new Card(12, "spades");
		hand = new Hand();
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
		c1 = new Card(2, "diamonds");
		c2 = new Card(2, "spades");
		c3 = new Card(12, "clubs");
		c4 = new Card(12, "hearts");
		c5 = new Card(12, "spades");
		hand = new Hand();
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
		c1 = new Card(2, "diamonds");
		c2 = new Card(2, "spades");
		c3 = new Card(12, "clubs");
		c4 = new Card(12, "hearts");
		c5 = new Card(12, "spades");
		hand = new Hand();
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
