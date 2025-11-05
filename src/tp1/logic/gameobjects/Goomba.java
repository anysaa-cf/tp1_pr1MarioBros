package tp1.logic.gameobjects;

import tp1.logic.Action;
import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.Position;
import tp1.view.Messages;

public class Goomba extends MovingObject {
	//private boolean isMobile; // characteristic from goomba
	
	public Goomba(Game game, Position pos) {
		super(game, pos, Action.RIGHT);
		//this.isMobile = true;		// initial movement from right to left
	}
	
	public String getIcon() {
		return Messages.GOOMBA;		
	}
	
	protected void move() {
		if(isAlive()) {														
			if(isFalling()) {
				Position posBelow = new Position(getRow() + 1, getCol());
				if(!game.isInsideBounds(posBelow))			
					goombaDies(); // goomba dies (for now) if it falls out of the map
				else
					updatePos(posBelow);	// if there is no ground below, it falls 1 cell	
			} else {			// if there is ground it moves horizontally
				int nextCol = getCol() + action.getY();
				int nextRow = getRow() + action.getX();
				Position nextPos = new Position(nextRow, nextCol);// get the next position given the action
				if(game.isInsideBounds(nextPos) && !game.isInsideBounds(nextPos)) {
					updatePos(nextPos);
				} else {
					changeAction();
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
		game.tryInteractionsFrom(this);
	}

	public void goombaDies() {
		objectDies();
	}

	@Override
	public boolean interactWith(GameItem other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveInteraction(Ground ground) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveInteraction(Mario mario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveInteraction(ExitDoor door) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveInteraction(Goomba goomba) {
		// TODO Auto-generated method stub
		return false;
	}
}
