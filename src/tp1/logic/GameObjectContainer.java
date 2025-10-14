package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;
import tp1.view.Messages;

public class GameObjectContainer {
	
	private Ground[] groundObjects;
	private Goomba[] goombaObjects;
	private ExitDoor exitDoor;		// there is just 1 exit door so no array needed
	private Mario marioObject;		// there is just 1 mario so no array needed
	private Game game;
	
	private int groundCounter;
	private int goombaCounter;
	
	public GameObjectContainer(int groundCounter, int goombaCounter, Game game) {
		// arrays are created with each position in null by default
		
		this.groundCounter = groundCounter;
		groundObjects = new Ground[groundCounter];		

		this.goombaCounter = goombaCounter;
		goombaObjects = new Goomba[goombaCounter];	
		
		this.game = game;
	}
	
	public void add(Ground ground) {		
		// checks if the array has null positions and adds a ground there until it is completed
		for(int i = 0; i < groundCounter; i++) {
			if(groundObjects[i] == null) {
				groundObjects[i] = ground;
				return;
			}
		}
	}
	
	public void add(Goomba goomba) {
		// checks if the array has null positions and adds a goomba there until it is completed
		for(int i = 0; i < goombaCounter; i++) {
			if(goombaObjects[i] == null) {
				goombaObjects[i] = goomba;
				return;
			}
		}
		
	}
	
	public void add(ExitDoor exit) {	// checks if there is no exitDoor and adds one
		this.exitDoor = exit;
		return;
		/*if(exitDoor == null) {		// it is not that necessary
			this.exitDoor = exit;
			return;
		}*/
	}
	
	public void add(Mario mario) {
		this.marioObject = mario;
		return;
		/*if(mario == null) {
			this.marioObject = mario;
			return;
		}*/
		
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
