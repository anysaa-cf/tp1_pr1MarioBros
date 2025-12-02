package tp1.control.commands;

import java.util.Arrays;

import tp1.exceptions.*;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.logic.GameWorld;
import tp1.logic.GameObject;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObjectFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class AddObjectCommand extends AbstractCommand {
	
	private static final String NAME = Messages.COMMAND_ADD_OBJECT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ADD_OBJECT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ADD_OBJECT_DETAILS;
	private static final String HELP = Messages.COMMAND_ADD_OBJECT_HELP;
	
	private String objDescription[];
	
	public AddObjectCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(matchCommandName(commandWords[0])) {		// always identifies the command type in position 0
			if(commandWords.length < 3) {
				throw new CommandParseException(Messages.INVALID_COMMAND_PARAMETERS);
			}
			this.objDescription = Arrays.copyOfRange(commandWords, 1, commandWords.length);
			return this;
		}
		return null;
	}
	
	@Override
	public void execute(GameModel game, GameView view) throws CommandExecuteException {		
		try {
			if(game.getLevel() != -1)
				throw new CommandExecuteException("Invalid execute command in this level");
			GameObject obj = GameObjectFactory.parse(objDescription, (Game) game);
			game.addObj(obj);
			view.showGame();
		} catch(GameModelException gme) {
			throw new CommandExecuteException(Messages.ERROR_COMMAND_EXECUTE, gme);
		}
	}

	
	public String helpText() {
		return DETAILS + ": " + HELP;
	}


}
