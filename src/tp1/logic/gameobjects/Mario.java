package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario {

	private Position pos;
//	private Game game;
	private Action action = Action.STOP;

	private boolean big = true;		
	private boolean alive = true;
//	private boolean isMobile = true;
	
	private int numLivesLeft;
	
	public Mario(Game game, Position pos) {
		this.pos = pos;
//		this.game = game;
		numLivesLeft = game.numLives();		// numLives = 3 at the beginning
	}
	
	public void setDirection(Action action) {
		this.action = action;
	}
	
	public String getIcon() {
		String icon;
		
		switch(action) {
		case RIGHT:
			icon = Messages.MARIO_RIGHT;
			break;
		case LEFT:
			icon = Messages.MARIO_LEFT;
			break;
		default:
			icon = Messages.MARIO_STOP;		// by default mario's initial direction is set as left-to-right?¿
		}
		
		return icon;
	}
	
	
	
	
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		
	}
	
	public void marioDies() {
		if(alive) {
			numLivesLeft--;
			if(numLivesLeft <= 0) {
				alive = false;
			}
		}
	}
	
	public boolean onPosition(Position position) {
		return (this.pos.equals(position) || 
				(big && this.pos.equals(new Position(position.getRow() - 1, position.getCol()))));
	}
}
