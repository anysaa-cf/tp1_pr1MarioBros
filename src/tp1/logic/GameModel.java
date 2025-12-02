package tp1.logic;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.GameModelParseException;
import tp1.exceptions.GameSaveException;

public interface GameModel {
	// represent the Controller's view
	public boolean isFinished();
	public void update() throws GameModelException;
	public void reset() throws GameLoadException;
	public void exit();
	public void marioExited();
	public boolean addObj(GameObject obj);			
	public void addAction(Action action) throws GameModelException;
	public void setLevel(int level);
	public void initGame();
	public int getLevel();
	public void load(String fileName) throws GameLoadException;
	public void save(String fileName) throws GameSaveException;
}
