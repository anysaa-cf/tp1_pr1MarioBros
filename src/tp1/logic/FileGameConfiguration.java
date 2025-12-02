package tp1.logic;

import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.logic.gameobjects.Mario;

public class FileGameConfiguration implements GameConfiguration {
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
	}
	
	@Override
	public int remainingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int points() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numLives() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mario getMario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameObject> getNPCObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
