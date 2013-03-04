package game.cardscoring;

public interface Scorer {
	public int[] getScore();

	public String toReadableString();

	public int compareTo(Scorer scorer);
}
