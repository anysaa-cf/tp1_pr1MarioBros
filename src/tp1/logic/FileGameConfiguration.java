package tp1.logic;

import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.logic.gameobjects.Mario;

public class FileGameConfiguration implements GameConfiguration {
	private int remainingTime;
	private int points;
	private int lives;
	
	private Mario mario;
    private List<GameObject> npcObjects;
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
	}
	
	@Override
	public int remainingTime() {
		return remainingTime;
	}

	@Override
	public int points() {
		return points;
	}

	@Override
	public int numLives() {
		return lives;
	}

	@Override
	public Mario getMario() {
		return mario;
	}

	@Override
	public List<GameObject> getNPCObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
