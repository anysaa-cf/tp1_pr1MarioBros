package tp1.logic;

import tp1.exceptions.GameModelException;
import tp1.exceptions.GameModelParseException;
import tp1.exceptions.OffBoardException;

public interface GameWorld {
	// represent the Model's internal view 
	public void tryInteractionsFrom(GameItem object);
	public boolean isInsideBounds(Position position) throws OffBoardException;
	public boolean isDifferent(GameItem o1, GameItem o2);
	public void marioExited();
	public void marioDies();
	public void win();
	public void addPoints(int i);
	public boolean addObj(GameObject obj);	
	public void addAction(Action action) throws GameModelException;
	public boolean isSolid(Position nextPos);
	public int getLevel();
}
