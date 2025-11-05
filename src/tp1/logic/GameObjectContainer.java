package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.Mario;
import tp1.view.Messages;

public class GameObjectContainer {
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {	
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void add(GameObject object) {	// adding every object to the container without knowing which object is
		gameObjects.add(object);
	}
	
	public String positionToString(int col, int row) {
		Position pos = new Position(row, col);		// Position pos = new Position(col, row)?¿ 
		String icon = Messages.EMPTY;
		
		for(GameObject o: gameObjects) {
			if(o.isInPosition(pos)) {
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
	
	public void update() {
		for(GameObject o : gameObjects) {
			o.update();			// update needs to be also in the gameitem?¿
		}
	}

	public void doInteractionsFrom(Mario mario) {
		for(GameObject o : gameObjects) {
			mario.interactWith(o);
			o.interactWith(mario);
		}
		
	}
}
