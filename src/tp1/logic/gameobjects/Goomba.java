package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba extends MovingObject {
	private boolean isMobile; // characteristic from goomba
	private Action action;
	
	public Goomba(Game game, Position pos) {
		super(game, pos, Action.RIGHT);
		this.isMobile = true;		// initial movement from right to left
	}
	
	public String getIcon() {
		return Messages.GOOMBA;		
	}
	
	protected void move() {
		if(isAlive()) {
			Position posBelow = new Position(getRow() + 1, getCol());
			boolean groundBelow = isSolid(); 																		// TODO, REVISAR!!!
			
			if(!groundBelow) {	
				if(!game.isInsideBounds(posBelow)) {			
					goombaDies(); // goomba dies (for now) if it falls out of the map
				} else {
					updatePos(posBelow);	// if there is no ground below, it falls 1 cell		
				}
				
			} else {			// if there is ground it moves horizontally
				int nextCol = getCol() + action.getY();
				int nextRow = getRow() + action.getX();
				Position nextPos = new Position(nextRow, nextCol);// get the next position given the action
				
				boolean insideBounds = game.isInsideBounds(nextPos);
				boolean groundInFront = true; 																	//TODO, REVISAR!!!
				
				if(insideBounds && !groundInFront) {
					updatePos(nextPos);// moves 1 cell
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
