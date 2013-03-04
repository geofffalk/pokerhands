package game.cardanalysis;

import game.model.Card;
import game.model.Hand;

import java.util.ArrayList;

/**
 * Analyser class is an abstract class that is responsible for visiting a hand and scanning for
 * winning combinations. The value of the combination is stored in the
 * foundValues field.
 * 
 */
public abstract class Analyser {
	private ArrayList<Integer> foundValues;

	public Analyser() {
		foundValues = new ArrayList<>();
	}

	public void resetFoundValues() {
		foundValues = null;
		foundValues = new ArrayList<>();
	}

	public ArrayList<Integer> getFoundValues() {
		return foundValues;
	}

	public void addFoundValue(Integer i) {
		this.foundValues.add(i);
	}

	public abstract boolean visit(Card card);

	public abstract boolean visit(Hand card);

}
