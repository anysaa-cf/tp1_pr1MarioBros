package tp1.logic;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.GameModelParseException;
import tp1.exceptions.GameSaveException;

public interface GameModel {
	// represent the Controller's view
	
	public void initGame();
	public int getLevel();
	public void setLevel(int level);
	public boolean playerWins();
	public boolean playerLoses();
	public void update() throws GameModelException;
	public boolean isFinished();
	public void exit();
	public void reset() throws GameLoadException;
	public void marioExited();
	public void addAction(Action action) throws GameModelException;
	public void addObj(GameObject obj) throws GameModelException;	
	public void load(String fileName) throws GameLoadException;
	public void save(String fileName) throws GameSaveException;
}
