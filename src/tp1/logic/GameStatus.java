package tp1.logic;

public interface GameStatus extends GameRunStatus{
	// represent the View's view
	public String positionToString(int col, int row);
	public boolean playerWins();
	public boolean playerLoses();
}
