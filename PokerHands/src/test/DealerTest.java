package test;

import static org.junit.Assert.*;
import game.model.Card;
import game.model.Dealer;

import org.junit.Before;
import org.junit.Test;


public class DealerTest {
	Dealer dealer;

	@Before
	public void setUp() throws Exception {
		dealer = Dealer.getInstance();
	}

	@Test
	public void test() {
		Card c = dealer.dealACard();
		assertTrue(c instanceof Card);
	}
}
