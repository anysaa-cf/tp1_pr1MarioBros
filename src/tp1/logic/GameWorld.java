package tp1.logic;

import tp1.exceptions.GameModelException;

public interface GameWorld {
	// represent the Model's internal view 
	public void tryInteractionsFrom(GameItem object);
	public boolean isInsideBounds(Position position);
	public boolean isDifferent(GameItem o1, GameItem o2);
	public void marioExited();
	public void marioDies();
	public void win();
	public void addPoints(int i);
	public void addObj(GameObject obj) throws GameModelException;	
	public void addAction(Action action) throws GameModelException;
	public boolean isSolid(Position nextPos);
	void addMushroom(Position p);
}
