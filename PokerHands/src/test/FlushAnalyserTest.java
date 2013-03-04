package test;

import static org.junit.Assert.*;
import game.cardanalysis.Analyser;
import game.cardanalysis.FlushAnalyser;
import game.model.Card;
import game.model.Hand;

import org.junit.Before;
import org.junit.Test;


public class FlushAnalyserTest {
	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card c5;
	Hand hand;

	@Before
	public void setUp() throws Exception {
		c1 = new Card(2, "spades");
		c2 = new Card(3, "spades");
		c3 = new Card(4, "spades");
		c4 = new Card(5, "spades");
		c5 = new Card(6, "spades");
		hand = new Hand();
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
