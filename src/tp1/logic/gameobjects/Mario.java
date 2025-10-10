package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario {

	private Position pos;
	private Game game;
	private Action action = Action.STOP;

	private boolean big = true;		
	private boolean alive = true;
	private boolean isMobile = true;
	
	private int numLivesLeft;
	
	public Mario(Game game, Position pos) {
		this.pos = pos;
		this.game = game;
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
		case STOP:
		case UP:
		case DOWN:
		default:
			icon = Messages.MARIO_STOP;
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
	
	public boolean isMarioInPosition(Position position) {	// check if current mario position is in the position passed by argument
		return this.pos.equals(position);
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public boolean isBig() {
		return big;
	}
}
