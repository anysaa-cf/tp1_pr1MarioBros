package tp1.logic;

import java.io.*;
import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class FileGameConfiguration implements GameConfiguration {
	
	private String fileName;
	private GameWorld game;
	private Mario mario;
	private List<GameObject> gameObject;
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
		this.fileName = fileName;
		this.game = game;
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
				throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible time number");
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
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
				throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible points number");
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
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
				throw new GameLoadException(Messages.ERROR_COMMAND_LOAD + ", imposible lives parse");
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
		}
		
		return c;
	}

	@Override
	public Mario getMario() throws GameLoadException {
		BufferedReader fileIn = null;
		String str;
		try {
			fileIn = new BufferedReader(new FileReader(fileName));
			str = fileIn.readLine();
			String[] aux  = str.split(" ");
			mario = (Mario) GameObjectFactory.parse(aux, (Game)game);
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
		} catch(GameModelException gme) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, gme);
		} finally {
			try {
				fileIn.close();
			} catch (IOException ioe) {
				throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
			}
		}
		return mario;
	}



	@Override
	public List<GameObject> getNPCObjects() throws GameLoadException {
		BufferedReader fileIn = null;
		String str;
		try {
			fileIn = new BufferedReader(new FileReader(fileName));
			while ((str = fileIn.readLine()) != null) {
				String[] aux  = str.split(" ");
				gameObject.add(GameObjectFactory.parse(aux, (Game)game));
			}
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
		} catch(GameModelException gme) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, gme);
		} finally {
			try {
				fileIn.close();
			} catch (IOException ioe) {
				throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
			}
		}
		return gameObject;
	}

}
