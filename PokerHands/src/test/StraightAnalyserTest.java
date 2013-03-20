package test;

import static org.junit.Assert.*;
import game.cardanalysis.Analyser;
import game.cardanalysis.StraightAnalyser;
import game.model.Hand;
import game.model.PokerCard;
import game.model.PokerHand;

import org.junit.Before;
import org.junit.Test;


public class StraightAnalyserTest {

	PokerCard c1;
	PokerCard c2;
	PokerCard c3;
	PokerCard c4;
	PokerCard c5;
	Hand hand;

	@Before
	public void setUp() throws Exception {
		c1 = new PokerCard(8, "diamonds");
		c2 = new PokerCard(9, "spades");
		c3 = new PokerCard(11, "clubs");
		c4 = new PokerCard(12, "hearts");
		c5 = new PokerCard(10, "spades");
		hand = new PokerHand();
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
