package tp1.logic;

import tp1.exceptions.GameModelException;
import tp1.exceptions.GameModelParseException;

public interface GameModel {
	// represent the Controller's view
	public boolean isFinished();
	public void update() throws GameModelException;
	public void reset();
	public void exit();
	public void marioExited();
	public boolean addObj(GameObject obj);			
	public void addAction(Action action) throws GameModelException;
	public void setLevel(int level);
	public void initGame();
}
