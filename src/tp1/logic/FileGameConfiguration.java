package tp1.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;
import tp1.logic.Game;

public class FileGameConfiguration implements GameConfiguration {
	
	private String fileName;
	private GameWorld game;
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
		this.fileName = fileName;
	}
	
	@Override
	public int remainingTime() throws GameLoadException {
		FileReader fileIn = null;
		int c;
		try {
			fileIn = new FileReader(fileName);
			c = fileIn.read();
			fileIn.close();
			if(c < 0 || c > 100)
				throw new GameLoadException();
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible time number", ioe);
		}
		
		return c;
	}

	@Override
	public int points() throws GameLoadException {
		FileReader fileIn = null;
		int c;
		try {
			fileIn = new FileReader(fileName);
			c = fileIn.read();
			fileIn.close();
			if(c < 0)
				throw new GameLoadException();
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible points number", ioe);
		}
		
		return c;
	}

	@Override
	public int numLives() throws GameLoadException {
		FileReader fileIn = null;
		int c;
		try {
			fileIn = new FileReader(fileName);
			c = fileIn.read();
			fileIn.close();
			if(c < 0 || c > 3)
				throw new GameLoadException();
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible lives parse", ioe);
		}
		
		return c;
	}

	@Override
	public Mario getMario() throws GameLoadException {
		FileReader fileIn = null;
		Mario mario;
		try {
			fileIn = new FileReader(fileName);
			c = fileIn.read();
			fileIn.close();
			if(c < 0 || c > 3)
				throw new GameLoadException();
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible lives parse", ioe);
		}
		return mario;
	}

	@Override
	public List<GameObject> getNPCObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
