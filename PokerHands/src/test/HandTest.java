package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import game.model.Card;
import game.model.Hand;
import game.cardanalysis.FlushAnalyser;

import org.junit.Before;
import org.junit.Test;


public class HandTest {
	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card c5;
	Hand hand;

	@Before
	public void setUp() throws Exception {
		c1 = new Card(2,"spades");
		c2 = new Card(4,"spades");
		c3 = new Card(6,"spades");
		c4 = new Card(8,"spades");
		c5 = new Card(10,"spades");
	
		hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		hand.addCard(c5);
		
	}
	

	@Test
	public void removeCardTest() {
		String expectedResult = "[1: Four of spades\n, 2: Six of spades\n, 3: Eight of spades\n, 4: Ten of spades\n, null]";
		hand.removeCard(c1);
		String actualResult =  Arrays.toString(hand.toStringArray());
		assertEquals("Wrong!", expectedResult, actualResult);	
	}
	
	@Test
	public void addCardTest() {
		Card c6 = new Card (9,"spades");
		String expectedResult = "[1: Four of spades\n, 2: Six of spades\n, 3: Eight of spades\n, 4: Nine of spades\n, 5: Ten of spades\n]";
		hand.removeCard(c1);
		hand.addCard(c6);
		String actualResult = Arrays.toString(hand.toStringArray());
		assertEquals("Wrong!", expectedResult, actualResult);	
	}

	@Test
	public void AnalyseMeTest(){
		Boolean expectedResult = true;
		FlushAnalyser analyser = new FlushAnalyser();
		Boolean actualResult = (hand.analyseMe(analyser));
		assertEquals("Wrong!", expectedResult, actualResult);	
	}
	
	
	@Test
	public void getCardWithValueTest(){
		String expectedResult = "Four of spades";
		String actualResult = (hand.getCardWithValue(4).toString());
		assertEquals("Wrong!", expectedResult, actualResult);	
	}
	

	@Test
	public void getCardAtPositionTest() {
		String expectedResult = "Four of spades";
		String actualResult = (hand.getCardAtPosition(1).toString());
		assertEquals("Wrong!", expectedResult, actualResult);	
	}
	

	@Test
	public void PopulateJListTest(){
			String expectedResult = "[1: Two of spades\n, 2: Four of spades\n, 3: Six of spades\n, 4: Eight of spades\n, 5: Ten of spades\n]";
			String actualResult = Arrays.toString(hand.toStringArray());
			assertEquals("Wrong!", expectedResult, actualResult);	
	}	
}



