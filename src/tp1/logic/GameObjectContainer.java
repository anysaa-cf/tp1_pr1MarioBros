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
	
	public GameObjectContainer(int groundCounter, int goombaCounter, Game game) {	// maybe it does not receive the game as argument?¿
		gameObjects = new ArrayList<GameItem>();	
		this.game = game;
	}
	
	public void add(GameItem object) {	
		gameObjects.add(object);
	}
	
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
	}
}
