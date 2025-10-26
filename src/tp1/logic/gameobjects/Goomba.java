package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba extends MovingObject {
	private Position pos;
	private boolean isMobile;
	private Game game;		// needs to interact with the general state of the game or with other objects
	private Action action;
	
	private boolean alive = true;
	
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
	
	// I have changed the onPosition(Position position) to isInPosition(Position p)
	public boolean isInPosition(Position position) {
		return this.pos.equals(position);
	}
	
	public void update() {
		if(this.alive) {
			Position posBelow = new Position(pos.getRow() + 1, pos.getCol());
			boolean groundBelow = game.getGameObjects().areGroundsInPosition(posBelow);
			
			if(!groundBelow) {	
				if(!game.isInsideBounds(posBelow)) {			// goomba dies (for now) if it falls out of the map
					goombaDies();
				} else {
					pos = posBelow;						// if there is no ground below, it falls 1 cell		
				}
				
			} else {			// if there is ground it moves horizontally
				int nextCol = pos.getCol() + action.getY();
				int nextRow = pos.getRow() + action.getX();
				Position nextPos = new Position(nextRow, nextCol);		// get the next position given the action
				
				boolean insideBounds = game.isInsideBounds(nextPos);
				boolean groundInFront = game.getGameObjects().areGroundsInPosition(nextPos);
				
				if(insideBounds && !groundInFront) {
					pos = nextPos;		// moves 1 cell
				} else {
					changeAction();		// turns around
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

	public void goombaDies() {
		game.getGameObjects().removeGoomba(this);
	}

	public boolean receiveInteraction(Mario other) {
		this.alive = false;
		other.addPoints(100);
		this.goombaDies();
		
		return true;
	}

	// do not implement this functions?¿
	@Override
	public boolean isSolid(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}
}
