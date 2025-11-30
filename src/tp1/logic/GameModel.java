package tp1.logic;

import tp1.exceptions.GameModelException;

public interface GameModel {
	// represent the Controller's view
	public boolean isFinished();
	public void update() throws GameModelException;
	public void reset();
	public void exit();
	public void marioExited();
	public void addPoints(int newPoints);
	public void addObj(GameObject obj);		// throws GameModelException?¿
	public void addAction(Action action) throws GameModelException;
	public void setLevel(int level);
	public void initGame();
}
