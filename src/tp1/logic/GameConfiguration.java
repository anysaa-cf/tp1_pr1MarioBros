package tp1.logic;

import java.util.List;

import tp1.logic.gameobjects.Mario;

public interface GameConfiguration {
	public int remainingTime();
	public int points();
	public int numLives();
	public Mario getMario();
	public List<GameObject> getNPCObjects();
	
}
