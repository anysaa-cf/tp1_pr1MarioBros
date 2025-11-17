package tp1.control.commands;

import java.util.Arrays;

import tp1.logic.Game;
import tp1.logic.GameObject;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObjectFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class AddObjectCommand extends NoParamsCommand {
	
	private static final String NAME = Messages.COMMAND_ADD_OBJECT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ADD_OBJECT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ADD_OBJECT_DETAILS;
	private static final String HELP = Messages.COMMAND_ADD_OBJECT_HELP;
	
	private String objDescription[];
	
	public AddObjectCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {		// always identifies the command type in position 0
			this.objDescription = Arrays.copyOfRange(commandWords, 1, commandWords.length);
			return this;
		}
		return null;
	}
	
	@Override
	public void execute(Game game, GameView view) {
		String [] objDescr = String.join(" ", objDescription);
	
		GameObjectFactory factory = new GameObjectFactory();
		GameObject gameObj = factory.parse(objDescription, game);
		
		if(gameObj != null) {
			Position pos = new Position(gameObj.getRow(), gameObj.getCol());
			 if(game.isInsideBounds(pos)) {
				 game.addObj(gameObj);
				 view.showGame();
			 } else {
				 view.showError(Messages.INVALID_GAME_OBJECT.formatted(objDescr));				 
			 }
		} else {
			view.showError(Messages.INVALID_GAME_OBJECT.formatted(objDescr));
		}
	}

}
