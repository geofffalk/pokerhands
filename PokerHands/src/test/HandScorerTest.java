package test;

import static org.junit.Assert.*;

import game.cardscoring.HandScorer;
import game.cardscoring.Scorer;
import game.model.Card;
import game.model.Hand;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;




public class HandScorerTest {

	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card c5;
	Hand hand;

	@Before
	public void setUp() throws Exception {
	}
	
	
	@Test
	public void testForStraightFlush() {
		c1 = new Card(6, "diamonds");
		c2 = new Card(5, "diamonds");
		c3 = new Card(3, "diamonds");
		c4 = new Card(2, "diamonds");
		c5 = new Card(4, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[50, 6, 5, 4, 3, 2]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForPoker() {
		c1 = new Card(2, "diamonds");
		c2 = new Card(12, "diamonds");
		c3 = new Card(12, "clubs");
		c4 = new Card(12, "hearts");
		c5 = new Card(12, "spades");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[45, 12, 2, 0, 0, 0]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}

	@Test
	public void testForFullHouse() {
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
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[40, 12, 2, 0, 0, 0]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForFlush() {
		c1 = new Card(2, "spades");
		c2 = new Card(3, "spades");
		c3 = new Card(5, "spades");
		c4 = new Card(7, "spades");
		c5 = new Card(10, "spades");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[36, 10, 7, 5, 3, 2]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForStraight() {
		c1 = new Card(2, "spades");
		c2 = new Card(3, "spades");
		c3 = new Card(4, "spades");
		c4 = new Card(5, "spades");
		c5 = new Card(6, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[33, 6, 5, 4, 3, 2]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForThreeOfAKind() {
		c1 = new Card(5, "clubs");
		c2 = new Card(3, "spades");
		c3 = new Card(5, "hearts");
		c4 = new Card(5, "spades");
		c5 = new Card(6, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[30, 5, 6, 3, 0, 0]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForTwoPairs() {
		c1 = new Card(5, "clubs");
		c2 = new Card(10, "spades");
		c3 = new Card(5, "hearts");
		c4 = new Card(6, "spades");
		c5 = new Card(6, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[20, 6, 5, 10, 0, 0]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForOnePair() {
		c1 = new Card(14, "clubs");
		c2 = new Card(10, "spades");
		c3 = new Card(5, "hearts");
		c4 = new Card(6, "spades");
		c5 = new Card(6, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[10, 6, 14, 10, 5, 0]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForSingle() {
		c1 = new Card(14, "clubs");
		c2 = new Card(10, "spades");
		c3 = new Card(5, "hearts");
		c4 = new Card(3, "spades");
		c5 = new Card(6, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);
		int[] scoreCard = handScorer.getScore();
		String expectedResult = "[1, 14, 10, 6, 5, 3]";
		String actualResult = Arrays.toString(scoreCard);
		assertEquals("Wrong", expectedResult, actualResult);
	}
	
	@Test
	public void testForComparisonOfStraights() {
		c1 = new Card(14, "clubs");
		c2 = new Card(13, "spades");
		c3 = new Card(12, "hearts");
		c4 = new Card(11, "spades");
		c5 = new Card(10, "diamonds");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		Scorer handScorer = new HandScorer(hand);

		Card c6 = new Card(13, "clubs");
		Card c7 = new Card(12, "spades");
		Card c8 = new Card(11, "hearts");
		Card c9 = new Card(10, "spades");
		Card c10 = new Card(9, "diamonds");
		Hand hand2 = new Hand();
		hand2.addCard(c6);
		hand2.addCard(c7);
		hand2.addCard(c8);
		hand2.addCard(c9);
		hand2.addCard(c10);
		Scorer handScorer2 = new HandScorer(hand2);
		int expectedResult = 1;
		int actualResult = handScorer.compareTo(handScorer2);
			assertEquals("Wrong", expectedResult, actualResult);
	}

}
