package tp1.logic;

public interface GameStatus {
	// represent the View's view
	public int remainingTime();
	public int points();
	public int numLives();
	public String positionToString(int col, int row);
	public boolean playerWins();
	public boolean playerLoses();
}
