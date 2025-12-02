package tp1.logic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tp1.exceptions.GameSaveException;
import tp1.exceptions.OffBoardException;
import tp1.view.Messages;

public class GameObjectContainer {
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {	
		gameObjects = new ArrayList<GameObject>();
	}
	
	public boolean add(GameObject object) {	
		return gameObjects.add(object);
	}
	
	public String positionToString(int col, int row) {
		Position pos = new Position(row, col);		 
		String icon = Messages.EMPTY;		
		
		for(GameObject o: gameObjects) {
			if(o.isInPosition(pos) && o.isAlive()) {
				icon += o.getIcon();
			}
		}
		return icon;
	}
	
	public boolean isSolid(Position pos) {
		boolean solid = false;
		for(GameObject o : gameObjects) {
			if(o.isInPosition(pos) && o.isSolid()) {		
				solid = true;
			}
		}
		return solid;
	}
	
	public void update(){
		int aux = gameObjects.size();
		for(int i = 0; i < aux; i++) {
			GameObject o = gameObjects.get(i);
			o.update();
		}
	}

	public void tryInteractionsFrom(GameItem object) {
		int aux = gameObjects.size();
		for(int i = 0; i < aux; i++) { 
			GameObject o = gameObjects.get(i);
			object.interactWith(o);
			o.interactWith(object);
		}
	}
	
	public void write(BufferedWriter bw) throws GameSaveException {
		try {
			for(GameObject o: gameObjects) {
				if(o.canWrite) {
					bw.write(o.toString());
					bw.newLine();
				}
			}
		} catch(IOException ioe) {
			throw new GameSaveException(Messages.ERROR_COMMAND_SAVE, ioe);
		}
	}
}
