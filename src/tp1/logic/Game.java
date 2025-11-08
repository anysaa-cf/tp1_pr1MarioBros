
package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;

public class Game implements GameModel, GameStatus, GameWorld {

	public static final int DIM_X = 30;
	public static final int DIM_Y = 15;

	private int remainingTime;
	private int points;
	private int nLevel;
	private Mario mario; 
	private GameObjectContainer gameObjects;
	private boolean win;
	private boolean lose;
	private boolean exit;
	
	public Game(int nLevel) {
		this.remainingTime = 100;
		this.points = 0;
		this.win = this.lose = this.exit = false;
		if(nLevel == 0 || nLevel == 1) {
			this.nLevel = nLevel;
			initGame();			
		}
	}
	
	public void initGame() {		
		switch(nLevel) {
		case 0:
			initLevel0();
			break;
		case 1:
			initLevel1();
			break;
		}
	}
	
	public void hit() {
		mario.marioDies();
	}
	
	public String positionToString(int col, int row) {
		return gameObjects.positionToString(col, row);
	}

	public boolean playerWins() {
		return this.win;
	}
	
	public void win() {
		this.win = true;
	}
	
	public void lose() {
		this.lose = true;
	}
	
	public boolean playerLoses() {
		return this.lose;
	}

	public int remainingTime() {
		return remainingTime;
	}

	public int points() {
		return points;
	}

	public int numLives() {
		return 0;
	}

	// creation of the update method
	public void update() {
			remainingTime = remainingTime() - 1;		// time is reduced by 1 on each cycle
			gameObjects.update();
	}
	
	public boolean isSolid(Position pos) {
		return gameObjects.isSolid(pos);	
	}
	
	public boolean isFinished() {
		return playerWins() || playerLoses() || this.exit;
	}
	
	public void exit() {
		this.exit = true;
	}
	
	public void reset() {
		this.remainingTime = 100;
		initGame();
	}

	private void initLevel0() {
		this.nLevel = 0;
		this.remainingTime = 100;
		gameObjects = new GameObjectContainer();
	
		for(int col = 0; col < 15; col++) {
			gameObjects.add(new Ground(this, new Position(13,col)));
			gameObjects.add(new Ground(this, new Position(14,col)));		
		}

		gameObjects.add(new Ground(this, new Position(Game.DIM_Y-3,9)));
		gameObjects.add(new Ground(this, new Position(Game.DIM_Y-3,12)));
		for(int col = 17; col < Game.DIM_X; col++) {
			gameObjects.add(new Ground(this, new Position(Game.DIM_Y-2, col)));
			gameObjects.add(new Ground(this, new Position(Game.DIM_Y-1, col)));		
		}

		gameObjects.add(new Ground(this, new Position(9,2)));
		gameObjects.add(new Ground(this, new Position(9,5)));
		gameObjects.add(new Ground(this, new Position(9,6)));
		gameObjects.add(new Ground(this, new Position(9,7)));
		gameObjects.add(new Ground(this, new Position(5,6)));
		
		// Final jump
		int tamX = 8, tamY= 8;
		int posIniX = Game.DIM_X-3-tamX, posIniY = Game.DIM_Y-3;
		
		for(int col = 0; col < tamX; col++) {
			for (int fila = 0; fila < col+1; fila++) {
				gameObjects.add(new Ground(this, new Position(posIniY- fila, posIniX+ col)));
			}
		}

		gameObjects.add(new ExitDoor(this, new Position(Game.DIM_Y-3, Game.DIM_X-1)));

		// 3. GameObjects
		this.mario = new Mario(this, new Position(Game.DIM_Y-3, 0));
		gameObjects.add(mario);

		gameObjects.add(new Goomba(this, new Position(0, 19)));
	}
	
	private void initLevel1() {
		this.nLevel = 0;
		this.remainingTime = 100;
		gameObjects = new GameObjectContainer();
	
		for(int col = 0; col < 15; col++) {
			gameObjects.add(new Ground(this, new Position(13,col)));
			gameObjects.add(new Ground(this, new Position(14,col)));		
		}

		gameObjects.add(new Ground(this, new Position(Game.DIM_Y-3,9)));
		gameObjects.add(new Ground(this, new Position(Game.DIM_Y-3,12)));
		for(int col = 17; col < Game.DIM_X; col++) {
			gameObjects.add(new Ground(this, new Position(Game.DIM_Y-2, col)));
			gameObjects.add(new Ground(this, new Position(Game.DIM_Y-1, col)));		
		}

		gameObjects.add(new Ground(this, new Position(9,2)));
		gameObjects.add(new Ground(this, new Position(9,5)));
		gameObjects.add(new Ground(this, new Position(9,6)));
		gameObjects.add(new Ground(this, new Position(9,7)));
		gameObjects.add(new Ground(this, new Position(5,6)));
		
		// Final jump
		int tamX = 8, tamY= 8;
		int posIniX = Game.DIM_X-3-tamX, posIniY = Game.DIM_Y-3;
		
		for(int col = 0; col < tamX; col++) {
			for (int fila = 0; fila < col+1; fila++) {
				gameObjects.add(new Ground(this, new Position(posIniY- fila, posIniX+ col)));
			}
		}

		gameObjects.add(new ExitDoor(this, new Position(Game.DIM_Y-3, Game.DIM_X-1)));

		// 3. GameObjects
		this.mario = new Mario(this, new Position(Game.DIM_Y-3, 0));
		gameObjects.add(mario);

		gameObjects.add(new Goomba(this, new Position(0, 19)));
		gameObjects.add(new Goomba(this, new Position(4, 6)));
		gameObjects.add(new Goomba(this, new Position(12, 6)));
		gameObjects.add(new Goomba(this, new Position(12, 8)));
		gameObjects.add(new Goomba(this, new Position(10, 10)));
		gameObjects.add(new Goomba(this, new Position(12, 11)));
		gameObjects.add(new Goomba(this, new Position(12, 14)));
	}
	
	public void addAction(Action action) {
		mario.addAction(action);
	}
	
	public void marioExited() {
		this.points = remainingTime * 10;
		this.win = true;
	}

	public void tryInteractionsFrom(GameItem object) {		// delegates the doInteractionsFrom() to the container
		gameObjects.tryInteractionsFrom(object);
	}

	public void marioDies() {
		this.lose = true;
	}

	public void addPoints(int newPoints) {
		this.points += newPoints;
	}
	
	public boolean isDifferent(GameItem o1, GameItem o2) {
		return o1.hashCode() != o2.hashCode();
	}
	
	public boolean isInsideBounds(Position position) {
		int row = position.getRow();
		int col = position.getCol();
		
		return row >= 0 && row < Game.DIM_Y && col >= 0 && col < Game.DIM_X;
	}

}
