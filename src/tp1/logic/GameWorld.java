package tp1.logic;

public interface GameWorld {
	// represent the Model's internal view 
	public int remainingTime();
	public int points();
	public int numLives();
	public void tryInteractionsFrom(GameItem object);
	public void addPoints(int newPoints);	
}
