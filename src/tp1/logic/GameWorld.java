package tp1.logic;

import java.util.List;

public interface GameWorld {
	// represent the Model's internal view 
	
	public int remainingTime();
	public int points();
	public int numLives();
	public List<GameObject> getContainer();
	public boolean isSolid(Position nextPos);
	public void addMushroom(Position p);
	public void addFireball(Position p, Action action);
	public void onEntry();
	public void marioExited();
	public void tryInteractionsFrom(GameItem object);
	public void marioDies();
	public void addPoints(int i);
	public boolean isDifferent(GameItem o1, GameItem o2);
	public boolean isInsideBounds(Position position);
	
	public void win();
	public void lose();
}
