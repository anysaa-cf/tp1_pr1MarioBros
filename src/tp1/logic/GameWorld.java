package tp1.logic;

import tp1.logic.gameobjects.Goomba;

public interface GameWorld {
	// represent the Model's internal view 
	public int remainingTime();
	public int points();
	public int numLives();
	public void tryInteractionsFrom(GameItem object);
	public void addPoints(int newPoints);
	public boolean isInsideBounds(Position nextPos);
	public boolean isDifferent(GameItem o1, GameItem o2);
	public void marioExited();
	public void marioDies();
	public void win();
	public boolean isSolid(Position nextPos);	
}
