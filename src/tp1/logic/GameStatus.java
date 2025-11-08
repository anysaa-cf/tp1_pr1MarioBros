package tp1.logic;

public interface GameStatus {
	// represent the View's view
	public String positionToString(int col, int row);
	public int points();
	public boolean playerWins();
	public boolean playerLoses();
}
