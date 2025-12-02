package tp1.logic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class FileGameConfiguration implements GameConfiguration {
	
	private String fileName;
	private int lives = 0;
	private int time = 0;
	private int points = 0;
	private GameWorld game;
	private Mario mario;
	private List<GameObject> gameObject;
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
		this.fileName = fileName;
		this.game = game;
		mario = new Mario(null, null);
		gameObject = new ArrayList<GameObject>();
		
	}
	
	public void read() throws GameLoadException{
		InputStreamReader isr = null;
		BufferedReader br = null;
		String aux;
		String [] split;
		try {
			isr = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_16LE);
			br = new BufferedReader(isr);
			time = Integer.parseInt(br.readLine().trim());
			points = Integer.parseInt(br.readLine().trim());
			lives = Integer.parseInt(br.readLine().trim());
			aux = br.readLine();
			split = aux.split(" ");
			mario = (Mario) GameObjectFactory.parse(split, (Game) game);
			while ((aux = br.readLine()) != null) {
				split  = aux.split(" ");
				gameObject.add(GameObjectFactory.parse(split, (Game)game));
			}
		} catch (IOException ioe) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
		} catch(GameModelException gme) {
			throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, gme);
		} finally {
			try {
				if(br != null)br.close();
			} catch (IOException ioe) {
				throw new GameLoadException(Messages.ERROR_COMMAND_LOAD, ioe);
			}
		}
	}
	
	@Override
	public int remainingTime() {
		return time;
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
	public Mario getMario(){
		return mario;
	}

	@Override
	public List<GameObject> getNPCObjects(){
		return gameObject;
	}

}
