package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;

public class GameObjectContainer {
	private Ground[] groundObjects;
	
	private Goomba[] goombaObjects;
	private ExitDoor exitDoor;		// there is just 1 exit door so no array needed
	private Mario[] marioObjects;
	
	// initialize the counters to 0 ?¿
	private int groundCounter;
	private int goombaCounter;
	private int marioCounter;
	
	public GameObjectContainer(int groundCounter, int goombaCounter, int marioCounter) {
		// arrays are created with each position in null by default
		
		this.groundCounter = groundCounter;
		groundObjects = new Ground[groundCounter];		

		this.goombaCounter = goombaCounter;
		goombaObjects = new Goomba[goombaCounter];		
		
		this.marioCounter = marioCounter;
		marioObjects = new Mario[marioCounter];			// maybe quitar		
		
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
	
	public void add(ExitDoor exit) {	// checks if there is no exitDoor and adds one?¿
//		this.exitDoor = exit;
		if(exitDoor == null) {
			this.exitDoor = exit;
			return;
		}
	}
	
	public void add(Mario mario) {
		// checks if the array has null positions and adds a mario there until it is completed
		for(int i = 0; i < marioCounter; i++) {
			if(marioObjects[i] == null) {
				marioObjects[i] = mario;
				return;
			}
		}
		
	}
	
	public boolean areMariosInPosition(Position position) {
		int i = 0;
		boolean ok = false;
		
		while(i < marioCounter && ok == false && this.marioObjects[i] != null) {
			ok = marioObjects[i].isMarioInPosition(position);
			++i;
		}
		
		return ok;
	}
	
	public boolean areGoombasInPosition(Position position) {
		int i = 0;
		boolean ok = false;
		
		while(i < goombaCounter && ok == false && this.goombaObjects[i] != null) {
			ok = goombaObjects[i].isGoombaInPosition(position);
			++i;
		}
		
		return ok;
	}
	
	public boolean areGroundsInPosition(Position position) {
		int i = 0;
		boolean ok = false;
		
		while(i < groundCounter && ok == false && this.groundObjects[i] != null) {
			ok = groundObjects[i].isGroundInPosition(position);
			++i;
		}
		
		return ok;
	}
	
	public boolean exitDoorInPosition(Position position) {
		return this.exitDoor != null && this.exitDoor.isExitDoorInPosition(position);		// add condition of this.exitDoor != null
	}
	

	public void update() {		// update method calls each update from the corresponding gameObject
		for(int i = 0; i < marioCounter; i++) {
			marioObjects[i].update();
		}
		
		for(int i = 0; i < goombaCounter; i++) {
			goombaObjects[i].update();
		}
		
		for(int i = 0; i < groundCounter; i++) {
			groundObjects[i].update();
		}
		exitDoor.update();
	}
}
