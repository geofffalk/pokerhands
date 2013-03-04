package test;

import static org.junit.Assert.*;
import game.model.Card;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	Card card1;
	Card card2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		card1 = new Card(3,"diamonds");
		card2 = new Card(5,"spades");


	}

	@Test
	public void card1SuitTest() {
		String expectedResult = "diamonds";
		String actualResult = card1.getSuit();
		assertEquals("Wrong!", expectedResult, actualResult);
				
	}
	
	@Test
	public void card2ValueTest() {
		int expectedResult = 5;
		int actualResult = card2.getValue();
		assertEquals("Wrong!", expectedResult, actualResult);			
	}
	

	
	

}
