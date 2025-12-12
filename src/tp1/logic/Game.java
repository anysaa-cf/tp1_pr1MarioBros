
package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.FireBall;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;
import tp1.logic.gameobjects.Mushroom;
import tp1.view.Messages;

import java.io.*;
import java.util.List;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.GameSaveException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.Box;

public class Game implements GameModel, GameStatus, GameWorld {
	
	public static final int DIM_X = 30;
	public static final int DIM_Y = 15;

	private int remainingTime;
	private int points;
	private int nLevel;
	private int lives;
	private Mario mario; 
	private GameObjectContainer gameObjectContainer;
	private boolean win;
	private boolean lose;
	private boolean exit;
	private boolean addMushroom;
	private boolean addFireball;
	private Mushroom mr;
	private FireBall fb;
	private GameConfiguration previousConfig;
	
	public Game(int nLevel) {
		this.remainingTime = 100;
		this.points = 0;
		this.win = this.lose = this.exit = this.addMushroom = this.addFireball = false;
		
		this.nLevel = nLevel;
		initGame();			
	}
	
	public void initGame() {		
		switch(nLevel) {
		case -1:
			initEmptyLevel();
			break;
		case 0:
			initLevel0();
			break;
		case 1:
			initLevel1();
			break;
		}
	}
	
	public int getLevel() {
		
		return nLevel;
	}
	
	private void initEmptyLevel() {
		this.remainingTime = 100;
		this.lives = 3;
		gameObjectContainer = new GameObjectContainer();	// we don't add any object, the map is empty
	}

	public void setLevel(int level) {
		this.nLevel = level;
	}

	public String positionToString(int col, int row) {
		String icon = "";
		
		icon = gameObjectContainer.positionToString(col, row);
		
		if(nLevel == -1 && icon == "")
			icon = "*";
		
		return icon;
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
		if(mario != null) {
			lives = mario.getLife();			
		}
		return lives;
	}
	
	public List<GameObject> getContainer(){
		return gameObjectContainer.getContainer();
	}

	public void update() throws GameModelException {
		if(nLevel != -1) {
			remainingTime = remainingTime() - 1;		// time is reduced by 1 on each cycle
			gameObjectContainer.update();
			lives = numLives();
			onEntry();
		}
	}
	
	public boolean isSolid(Position pos) {
		return gameObjectContainer.isSolid(pos);	
	}
	
	public boolean isFinished() {
		return playerWins() || playerLoses() || this.exit;
	}
	
	public void exit() {
		this.exit = true;
	}
	
	public void reset() throws GameLoadException {
		if (previousConfig != null) {
	        this.remainingTime = previousConfig.remainingTime();
	        this.points = previousConfig.points();
	        this.lives = previousConfig.numLives();

	        this.mario = previousConfig.getMario();

	        this.gameObjectContainer = new GameObjectContainer();
	        for (GameObject obj : previousConfig.getNPCObjects()) {
	            gameObjectContainer.add(obj);
	        }

	    } else {
	        this.remainingTime = 100;
	        initGame();
	    }
	}

	private void initLevel0() {
		this.nLevel = 0;
		this.remainingTime = 100;
		gameObjectContainer = new GameObjectContainer();
	
		for(int col = 0; col < 15; col++) {
			gameObjectContainer.add(new Ground(this, new Position(13,col)));
			gameObjectContainer.add(new Ground(this, new Position(14,col)));		
		}

		gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-3,9)));
		gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-3,12)));
		for(int col = 17; col < Game.DIM_X; col++) {
			gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-2, col)));
			gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-1, col)));		
		}

		gameObjectContainer.add(new Ground(this, new Position(9,2)));
		gameObjectContainer.add(new Ground(this, new Position(9,6)));
		gameObjectContainer.add(new Ground(this, new Position(9,7)));
		gameObjectContainer.add(new Ground(this, new Position(5,6)));
		
		// Final jump
		int tamX = 8, tamY= 8;
		int posIniX = Game.DIM_X-3-tamX, posIniY = Game.DIM_Y-3;
		
		for(int col = 0; col < tamX; col++) {
			for (int fila = 0; fila < col+1; fila++) {
				gameObjectContainer.add(new Ground(this, new Position(posIniY- fila, posIniX+ col)));
			}
		}

		gameObjectContainer.add(new ExitDoor(this, new Position(Game.DIM_Y-3, Game.DIM_X-1)));

		// 3. GameObjects
		this.mario = new Mario(this, new Position(Game.DIM_Y-3, 0));
		gameObjectContainer.add(mario);
		
		gameObjectContainer.add(new Box(this, new Position(9, 5)));
		gameObjectContainer.add(new Mushroom(this, new Position(8, 7)));
		gameObjectContainer.add(new Goomba(this, new Position(0, 19)));
	}
	
	private void initLevel1() {
		this.nLevel = 0;
		this.remainingTime = 100;
		gameObjectContainer = new GameObjectContainer();
	
		for(int col = 0; col < 15; col++) {
			gameObjectContainer.add(new Ground(this, new Position(13,col)));
			gameObjectContainer.add(new Ground(this, new Position(14,col)));		
		}

		gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-3,9)));
		gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-3,12)));
		for(int col = 17; col < Game.DIM_X; col++) {
			gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-2, col)));
			gameObjectContainer.add(new Ground(this, new Position(Game.DIM_Y-1, col)));		
		}

		gameObjectContainer.add(new Ground(this, new Position(9,2)));
		gameObjectContainer.add(new Ground(this, new Position(9,5)));
		gameObjectContainer.add(new Ground(this, new Position(9,6)));
		gameObjectContainer.add(new Ground(this, new Position(9,7)));
		gameObjectContainer.add(new Ground(this, new Position(5,6)));
		
		// Final jump
		int tamX = 8, tamY= 8;
		int posIniX = Game.DIM_X-3-tamX, posIniY = Game.DIM_Y-3;
		
		for(int col = 0; col < tamX; col++) {
			for (int fila = 0; fila < col+1; fila++) {
				gameObjectContainer.add(new Ground(this, new Position(posIniY- fila, posIniX+ col)));
			}
		}

		gameObjectContainer.add(new ExitDoor(this, new Position(Game.DIM_Y-3, Game.DIM_X-1)));

		// 3. GameObjects
		this.mario = new Mario(this, new Position(Game.DIM_Y-3, 0));
		gameObjectContainer.add(mario);

		gameObjectContainer.add(new Goomba(this, new Position(0, 19)));
		gameObjectContainer.add(new Goomba(this, new Position(4, 6)));
		gameObjectContainer.add(new Goomba(this, new Position(12, 6)));
		gameObjectContainer.add(new Goomba(this, new Position(12, 8)));
		gameObjectContainer.add(new Goomba(this, new Position(10, 10)));
		gameObjectContainer.add(new Goomba(this, new Position(12, 11)));
		gameObjectContainer.add(new Goomba(this, new Position(12, 14)));
	}
	
	public void addAction(Action action) throws GameModelException {
		mario.addAction(action);
	}
	
	public void  addObj(GameObject obj) throws GameModelException{
			if(!isInsideBounds(new Position(obj.getRow(), obj.getCol())))
				throw new OffBoardException("Position outside the board.");
			else
				gameObjectContainer.add(obj);
	}
	
	public void addFireball(Position p, Action action) {
		if(!isSolid(p)) {
			fb = new FireBall(this, p);
			fb.setAction(action);
			addFireball = true; 
		}
	}
	
	public void addMushroom(Position p) {
		if(!isSolid(p)) {
			mr = new Mushroom(this, p);
			addMushroom = true; 
		}
	}
	
	public void onEntry() {
		try {
			if(addMushroom) {
				addMushroom = false;
				addObj(mr);
				tryInteractionsFrom(mr);
			}
			else if(addFireball) {
				addFireball = false;
				addObj(fb);
				tryInteractionsFrom(fb);
			}
		}catch(GameModelException gme) {
			System.out.println("Couldn't add a Mushroom: " + gme);
		}
	}
	
	public void marioExited() {
		this.points = remainingTime * 10;
		this.win = true;
	}

	public void tryInteractionsFrom(GameItem object) {		// delegates the doInteractionsFrom() to the container
		gameObjectContainer.tryInteractionsFrom(object);
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
			
		return (row > -1 && row < DIM_Y && col > -1 && col < DIM_X);
	}

	@Override
	public void load(String fileName) throws GameLoadException {
		GameConfiguration config = new FileGameConfiguration(fileName, this);
		
		this.remainingTime = config.remainingTime();
	    this.points = config.points();
	    this.lives = config.numLives();
	    this.gameObjectContainer = new GameObjectContainer();
	    gameObjectContainer.add(this.mario = config.getMario());
		
	   
	    
	    for (GameObject obj : config.getNPCObjects()) {
	        gameObjectContainer.add(obj);
	    }
	    
	    this.previousConfig = config;
	}

	@Override
	public void save(String fileName) throws GameSaveException {
		BufferedWriter bufferOut = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			bufferOut = new BufferedWriter(fw);
			bufferOut.write(String.valueOf(this.remainingTime) + " ");
			bufferOut.newLine();
			bufferOut.write(String.valueOf(this.points) + " ");
			bufferOut.newLine();
			bufferOut.write(String.valueOf(numLives()));
			bufferOut.newLine();
			bufferOut.write(mario.toString());
			bufferOut.newLine();
			gameObjectContainer.write(bufferOut);
		} catch(IOException ioe) {
			throw new GameSaveException(ioe.getMessage(), ioe);
		} finally {
			try {
				bufferOut.close();
			} catch (IOException ioe) {
				throw new GameSaveException(Messages.ERROR_COMMAND_SAVE, ioe);
			}
		}
		
	}

}
