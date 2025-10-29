package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba extends MovingObject {
	private Position pos;
	private boolean isMobile; // characteristic from goomba
	private Game game;		// needs to interact with the general state of the game or with other objects
	private Action action;
	
	public Goomba(Game game, Position pos) {
		super(game, pos);
		this.isMobile = true;
		this.game = game;
		this.pos = pos;
		this.action = Action.RIGHT;			// initial movement from right to left
	}
	
	public String getIcon() {
		return Messages.GOOMBA;		
	}
	
	public boolean isInPosition(Position pos) {
		return this.pos.equals(pos);
	}
	
	protected void move() {
		if(isAlive()) {
			Position posBelow = new Position(pos.getRow() + 1, pos.getCol());
			boolean groundBelow = true; 																		// TODO, REVISAR!!!
			
			if(!groundBelow) {	
				if(!game.isInsideBounds(posBelow)) {			
					goombaDies(); // goomba dies (for now) if it falls out of the map
				} else {
					pos = posBelow;	// if there is no ground below, it falls 1 cell		
				}
				
			} else {			// if there is ground it moves horizontally
				int nextCol = pos.getCol() + action.getY();
				int nextRow = pos.getRow() + action.getX();
				Position nextPos = new Position(nextRow, nextCol);// get the next position given the action
				
				boolean insideBounds = game.isInsideBounds(nextPos);
				boolean groundInFront = true; 																	//TODO, REVISAR!!!
				
				if(insideBounds && !groundInFront) {
					pos = nextPos;// moves 1 cell
				} else {
					changeAction();// turns around
				}
			}
		}	
	}
	
	private void changeAction() {
		if(action == Action.RIGHT) {
			action = Action.LEFT;
		} else if(action == Action.LEFT) {
			action = Action.RIGHT;
		}	
	}
	
	public void update() {
		move();
	}

	public void goombaDies() {
		objectDies();
	}
}
