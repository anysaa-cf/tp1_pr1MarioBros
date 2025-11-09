package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import tp1.view.Messages;

public class GameObjectContainer {
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {	
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void add(GameObject object) {	
		gameObjects.add(object);
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
	
	public void update() {
		for(GameObject o : gameObjects) {
			o.update();			
		}
	}

	public void tryInteractionsFrom(GameItem object) {
		for(GameObject o : gameObjects) {
			object.interactWith(o);
			o.interactWith(object);
		}
		
	}
}
