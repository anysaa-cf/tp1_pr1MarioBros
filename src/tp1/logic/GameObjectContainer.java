package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;
import tp1.view.Messages;

public class GameObjectContainer {
	private Game game;
	private List<GameItem> gameObjects;		// private List<GameObject> ?¿
	
	public GameObjectContainer() {	
		gameObjects = new ArrayList<GameItem>();	
	}
	
	public void add(GameItem object) {	// adding every object to the container without knowing which object is
		gameObjects.add(object);
	}
	
	public String positionToString(int col, int row) {
		Position pos = new Position(row, col);		// Position pos = new Position(col, row)?¿ 
		String icon = Messages.EMPTY;
		
		for(GameItem o: gameObjects) {
			if(o.isInPosition(pos)) {
				icon += o.getIcon();
			}
		}
		return icon;
	}
	
	public boolean isSolid(Position pos) {
		boolean solid = false;
		for(GameItem o : gameObjects) {
			if(o.isInPosition(pos) && o.isSolid(pos) && o.isAlive(pos)) {
				solid = true;
			}
		}
		return false;
	}
	
	public boolean areGroundsInPosition(Position pos) {
		Position below = new Position(pos.getRow() + Action.DOWN.getX(), pos.getCol() + Action.DOWN.getY());
		return isSolid(below);
	}
	
	public void update() {
		for(GameItem o : gameObjects) {
			o.update();
		}
	}
	/*
	public String positionToStr(Position pos) {
		String icon = Messages.EMPTY;
		
		// mario object
		if(marioObject != null && marioObject.onPosition(pos)) {
			icon = marioObject.getIcon();
		} 
		
		// exitDoor object
		else if(exitDoor != null && exitDoor.onPosition(pos)) {
			icon = exitDoor.getIcon();
		} 
		
		// goomba objects
		else {
			for(Goomba goomba : goombaObjects) {
				if(goomba != null && goomba.onPosition(pos)) {
					icon = goomba.getIcon();
					break;		// once it has found a goomba on position, goes to the next element pending to check
				}
			}
		}
		
		// ground objects that will always be painted in the display (at least for now)
		for(Ground ground : groundObjects) {
			if(ground != null && ground.onPosition(pos)) {
				icon = ground.getIcon();
				break;
			}
		}
		
		return icon;
	}

	public void update() {		// update method calls each update from the corresponding gameObject
		marioObject.restartC(); // re start counters of actions for next update
		
		if(marioObject.actionListIsEmpty()) { // if there is no action
			if(marioObject != null) {
				marioObject.update();			
			}
			
			if(marioObject.interactWith(exitDoor)) {
				game.marioExited();
			}
	
			for(Goomba goomba : goombaObjects) {
				if(goomba != null) {
					goomba.update();
				}
			}

			doInteractionsFrom(marioObject);
		}
		else { // there is action
			while(!game.playerWins() && !game.playerLoses() && !marioObject.actionListIsEmpty()) {
				if(marioObject != null) {
					marioObject.update();			
				}
				
				if(marioObject.interactWith(exitDoor)) {
					game.marioExited();
				}
		
				for(Goomba goomba : goombaObjects) {
					if(goomba != null) {
						goomba.update();
					}
				}
				
				doInteractionsFrom(marioObject);
			}
		}
	}

	public boolean areGroundsInPosition(Position position) {
		for(Ground ground : groundObjects) {
			if(ground != null && ground.onPosition(position)) {
				return true;
			}
		}
		return false;	
	}
	
	public void removeGoomba(Goomba goombaDead) {
		for(int i = 0; i < goombaCounter; i++) {
			if(goombaObjects[i] == goombaDead) {
				goombaObjects[i] = null;
				return;
			}
		}
	}
	
	public void removeMario() {
		marioObject = null;	
	}
	
	public void addAction(Action action) {
		marioObject.addAction(action);
	}

	public void doInteractionsFrom(Mario mario) {
		for(Goomba goomba : goombaObjects) {
			if(goomba != null) {
				mario.interactWith(goomba);
			}
		}
	}*/
}
