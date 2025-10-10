package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;
import tp1.view.Messages;

public class Game {

	public static final int DIM_X = 30;
	public static final int DIM_Y = 15;

	private int remainingTime = 100;
	private int points = 0;
	private int nLevel = 0;

	private int groundCounter;
	private int goombaCounter;
	private int marioCounter;
	
	private GameObjectContainer gameObjects;
//	private Mario mario;
	
	public Game(int nLevel) {
		if(nLevel == 0 || nLevel == 1) {
			this.nLevel = nLevel;
			initGame(nLevel);			
		}
	}
	
	public void initGame(int nLevel) {		// selection of the level
		switch(nLevel) {
		case 0:
			initLevel0();
			break;
		case 1:
			// initLevel1();
			break;
		}
	}
	
	public String positionToString(int col, int row) {		
		Position pos = new Position(row, col);
		String str = Messages.EMPTY;
		
		if(gameObjects.areGroundsInPosition(pos)) {
			str += Messages.LAND;				//	return Messages.LAND;	
		}
		
		else if(gameObjects.areGoombasInPosition(pos)) {
			str += Messages.GOOMBA;				//	return Messages.GOOMBA;	
		}
		
		else if(gameObjects.exitDoorInPosition(pos)) {
			str += Messages.EXIT_DOOR;			//	return Messages.EXIT_DOOR;	
		}		
		
		else {
			Mario mario = gameObjects.getMario();
			
			if(mario != null) {
				Position marioPos = mario.getPosition();		// get the position of the existing mario
				
				if(mario.isBig()) {		// if big == true
					// in each loop it checks where to paint a mario
					if(pos.equals(marioPos) ||
							pos.equals(new Position(marioPos.getRow() - 1, marioPos.getCol()))){
						str = mario.getIcon();
					}
				}
				else if(pos.equals(marioPos)) {
					str = mario.getIcon();		// when big == false, it will only paint one mario
				}
			}
		}
		return str;
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public int remainingTime() {
		return remainingTime;
	}

	public int points() {
		return points;
	}

	public int numLives() {
		return 3;
	}

	// creation of the update method
	public void update() {
		remainingTime = remainingTime() - 1;		// time is reduced by 1 on each cycle
		gameObjects.update();			// method getGameObjects() is not necessary
		/*if (gameHasAction()) {
			points are modified;
		}*/
	}


	@Override
	public String toString() {			// this is what the positionToString() does?¿
		// TODO returns a textual representation of the object
		return "TODO: Hola soy el game";
	}

	public boolean playerLoses() {
		// TODO Auto-generated method stub
		return false;
	} 
	
	public void resetGame() {
		initGame(nLevel);
	}

	private void initLevel0() {
		this.nLevel = 0;
		this.remainingTime = 100;
		
		groundCounter = 200;
		goombaCounter = 1;		// in this map there is only one goomba?¿
		marioCounter = 1;
		
		// 1. Mapa
		gameObjects = new GameObjectContainer(groundCounter, goombaCounter, marioCounter);
		for(int col = 0; col < 15; col++) {
			gameObjects.add(new Ground(new Position(13,col)));
			gameObjects.add(new Ground(new Position(14,col)));		
		}

		gameObjects.add(new Ground(new Position(Game.DIM_Y-3,9)));
		gameObjects.add(new Ground(new Position(Game.DIM_Y-3,12)));
		for(int col = 17; col < Game.DIM_X; col++) {
			gameObjects.add(new Ground(new Position(Game.DIM_Y-2, col)));
			gameObjects.add(new Ground(new Position(Game.DIM_Y-1, col)));		
		}

		gameObjects.add(new Ground(new Position(9,2)));
		gameObjects.add(new Ground(new Position(9,5)));
		gameObjects.add(new Ground(new Position(9,6)));
		gameObjects.add(new Ground(new Position(9,7)));
		gameObjects.add(new Ground(new Position(5,6)));
		
		// Salto final
		int tamX = 8, tamY= 8;
		int posIniX = Game.DIM_X-3-tamX, posIniY = Game.DIM_Y-3;
		
		for(int col = 0; col < tamX; col++) {
			for (int fila = 0; fila < col+1; fila++) {
				gameObjects.add(new Ground(new Position(posIniY- fila, posIniX+ col)));
			}
		}

		gameObjects.add(new ExitDoor(new Position(Game.DIM_Y-3, Game.DIM_X-1)));

		// 3. Personajes
//		this.mario = new Mario(this, new Position(Game.DIM_Y-3, 0));
		Mario mario = new Mario(this, new Position(Game.DIM_Y-3, 0));
		gameObjects.add(mario);

		gameObjects.add(new Goomba(this, new Position(0, 19)));
	}



	
}
