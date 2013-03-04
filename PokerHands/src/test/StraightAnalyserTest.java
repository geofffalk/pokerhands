package test;

import static org.junit.Assert.*;
import game.cardanalysis.Analyser;
import game.cardanalysis.StraightAnalyser;
import game.model.Card;
import game.model.Hand;

import org.junit.Before;
import org.junit.Test;


public class StraightAnalyserTest {

	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card c5;
	Hand hand;

	@Before
	public void setUp() throws Exception {
		c1 = new Card(8, "diamonds");
		c2 = new Card(9, "spades");
		c3 = new Card(11, "clubs");
		c4 = new Card(12, "hearts");
		c5 = new Card(10, "spades");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
	}

	@Test
	public void test() {
		Analyser straightAnalyser = new StraightAnalyser();
		boolean expectedResult = true;
		boolean actualResult = hand.analyseMe(straightAnalyser);
		assertEquals("Wrong", expectedResult, actualResult);

	}
	



}
