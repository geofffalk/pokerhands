package test;

import static org.junit.Assert.*;

import game.model.ComputerPlayer;
import game.model.Player;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;



public class ComputerPlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testForFullHouse() {
		int[] scoreCard = {40, 12, 2, 0, 0, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForStraightFlush() {
		int[] scoreCard = {50, 12, 11, 10, 9, 8};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForPokerWithLowExtraCard() {
		int[] scoreCard = {45, 12, 7, 0, 0, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {7,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForPokerWithHighExtraCard() {
		int[] scoreCard = {45, 12, 11, 0, 0, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForFlush() {
		int[] scoreCard = {36, 12, 11, 8, 2, 4};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForStraight() {
		int[] scoreCard = {33, 12, 11, 10, 9, 8};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForThreeOfAKind() {
		int[] scoreCard = {30, 2, 12, 11, 0, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {12,11,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForTwoPairs() {
		int[] scoreCard = {20, 4, 2, 11, 0, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {11,0,0,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForPairsWithHighSingle() {
		int[] scoreCard = {10, 4, 12, 11, 9, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0,11,9,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForPairsWithLowSingle() {
		int[] scoreCard = {10, 4, 8, 5, 4, 0};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {8,5,4,0,0};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForSinglesWithLowSingles() {
		int[] scoreCard = {0, 9, 8, 5, 4, 2};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {9, 8, 5, 4, 2};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}
	
	@Test
	public void testForSinglesWithHighSingles() {
		int[] scoreCard = {0, 14, 13, 12, 11, 2};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0, 0, 12, 11, 2};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}	
	
	@Test
	public void testForSinglesWithMixedSingles() {
		int[] scoreCard = {0, 14, 12, 6, 4, 2};
		Player computerPlayer = new ComputerPlayer();
		int[] expectedArray = {0, 0, 6, 4, 2};
		String expectedResult = Arrays.toString(expectedArray);
		String actualResult = Arrays.toString(computerPlayer.selectCardValuesToThrow(scoreCard));
		assertEquals("Wrong!", expectedResult, actualResult);
	}	
	
}
