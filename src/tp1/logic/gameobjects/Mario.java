package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Mario {

	private Position pos;
	private Action action;
	private Game game;

	private boolean big = true;		
	private boolean alive = true;
//	private boolean isMobile = true;
	
	private int numLivesLeft;
	
	public Mario(Game game, Position pos) {
		this.pos = pos;
		this.game = game;
		this.action = Action.RIGHT;
		numLivesLeft = game.numLives();		// numLives = 3 at the beginning
	}
	
	public String getIcon() {
		String icon;
		
		switch(this.action) {
		case UP: 
			icon = Messages.MARIO_STOP;
			break;
		case DOWN: 
			icon = Messages.MARIO_STOP;
			break;
		case RIGHT:
			icon = Messages.MARIO_RIGHT;
			break;
		case LEFT:
			icon = Messages.MARIO_LEFT;
			break;
		default:
			icon = Messages.MARIO_STOP;
			break;
		}
		return icon;
	}
	/**
	 *  Implements the automatic update	
	 */
	public void update(Action action) {
			Position nextPos = new Position(pos.getRow() + action.getX(), pos.getCol() + action.getY());
			boolean ground = game.getGameObjects().areGroundsInPosition(nextPos);
			
			if(!ground)
				switch(action) {
				
				case Action.RIGHT:
					pos = nextPos;
					break;
					
				case Action.LEFT:
					pos = nextPos;
					break;
				
				case Action.UP:
					pos = nextPos;
					break;
				
				case Action.DOWN:
					pos = nextPos;	
					break;
					
				case Action.STOP:
					break;
				}
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
				(big && this.pos.equals(new Position(position.getRow() + 1, position.getCol()))));
	}
}