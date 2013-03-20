package test;

import static org.junit.Assert.*;
import game.cardanalysis.Analyser;
import game.cardanalysis.FlushAnalyser;
import game.model.Hand;
import game.model.PokerCard;
import game.model.PokerHand;

import org.junit.Before;
import org.junit.Test;


public class FlushAnalyserTest {
	PokerCard c1;
	PokerCard c2;
	PokerCard c3;
	PokerCard c4;
	PokerCard c5;
	Hand hand;

	@Before
	public void setUp() throws Exception {
		c1 = new PokerCard(2, "spades");
		c2 = new PokerCard(3, "spades");
		c3 = new PokerCard(4, "spades");
		c4 = new PokerCard(5, "spades");
		c5 = new PokerCard(6, "spades");
		hand = new PokerHand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
	}


	@Test
	public void test() {
		Analyser flushAnalyser = new FlushAnalyser();
		boolean expectedResult = true;
		boolean actualResult = hand.analyseMe(flushAnalyser);
		assertEquals("Wrong", expectedResult, actualResult);

	}

}
