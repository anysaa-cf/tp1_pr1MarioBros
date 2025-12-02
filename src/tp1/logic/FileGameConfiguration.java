package tp1.logic;

import tp1.exceptions.GameLoadException;

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

}
