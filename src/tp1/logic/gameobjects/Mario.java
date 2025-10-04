package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario {

	private Position pos;
	private boolean isSolid = false;	// property of being a solid object
	private boolean big = false;		// when activated mario occupies the actual pos + actual pos + 1(y - axis) then it is drawn twice
	private Game game;
	private int numLivesLeft = 0;
	private Action action;
	private boolean alive = false;
	
	public Mario(Position pos, Action action, Game game) {
		this.pos = pos;
		this.action = action;
		this.game = game;
		alive = true;
	}
	
	public String getIcon() {
		changeDirection();
		
		return Messages.MARIO_STOP;		// change
	}
	
	public void setDirection(Action action) {
		this.action = action;
		this.setDirection(action);
	}
	
	public void changeDirection() {		// given an icon set the direction or given a direction set an icon?¿
		// if direction is right then Messages.MARIO_RIGHT
		// if direction is left then Messages.MARIO_LEFT
		if(this.getIcon() == Messages.MARIO_LEFT) {
			setDirection(Action.LEFT);
		} else if(this.getIcon() == Messages.MARIO_RIGHT) {
			setDirection(Action.RIGHT);
		} else {
			setDirection(Action.STOP);
		}
	}
	
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		//TODO fill your code
	}
	
	
	// i dont like this function
	public int marioDies() {		// mario dies when he is touched by a goomba or falls?¿
		if(alive) {
			numLivesLeft = this.game.numLives();
		}
		return numLivesLeft--;			
	}
	
	public boolean isMarioInPosition(Position position) {	// check if current mario position is in the position passed by argument
		return this.pos.equals(position);
	}
}
