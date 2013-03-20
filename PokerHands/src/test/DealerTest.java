package test;

import static org.junit.Assert.*;
import game.model.Card;
import game.model.Dealer;
import game.model.PokerCard;
import game.model.PokerDealer;

import org.junit.Before;
import org.junit.Test;


public class DealerTest {
	Dealer dealer;

	@Before
	public void setUp() throws Exception {
		dealer = PokerDealer.getInstance();
	}

	@Test
	public void test() {
		Card c = dealer.dealACard();
		assertTrue(c instanceof PokerCard);
	}
}
