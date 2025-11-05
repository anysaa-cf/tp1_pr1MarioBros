package tp1.logic.gameobjects;

import tp1.logic.GameObject;
import tp1.view.Messages;
import tp1.logic.Game;
import tp1.logic.GameItem;
import tp1.logic.Position;


public class ExitDoor extends GameObject {
	
	public ExitDoor(Game game,Position pos) {
		super(game, pos, false);
	}
	
	public String getIcon() {
		return Messages.EXIT_DOOR;		
	}
	
	public void update() {
		//Leave empty
	}

	public boolean isAlive() {
		//Leave empty
		return false;
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
