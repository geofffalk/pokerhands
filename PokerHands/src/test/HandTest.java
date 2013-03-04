package test;

import static org.junit.Assert.*;
import game.model.Card;
import game.model.Hand;

import org.junit.Before;
import org.junit.Test;


public class HandTest {
	Card c1;
	Card c2;
	Card c3;
	Hand hand;

	@Before
	public void setUp() throws Exception {
		c1 = new Card(2,"diamonds");
		c2 = new Card(4,"spades");
		c3 = new Card(6,"spades");
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.removeCard(c2);

	}


	
	@Test
	public void suitTest() {
		String expectedResult = null;
		String actualResult = hand.getSuit();
		assertEquals("Wrong suit", expectedResult, actualResult);
	}
	



}
