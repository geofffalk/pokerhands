package game.view;

import java.util.Observable;

/**Class allows delegation to observer.
 */
public class DelegatedObservable extends Observable {

	public void clearChanged() {
		super.clearChanged();
	}

	public void setChanged() {
		super.setChanged();
	}

}
