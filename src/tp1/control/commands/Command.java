package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.exceptions.*;

public interface Command {

	public void execute(Game game, GameView view);	  
	public abstract Command parse(String[] parameter) throws CommandParseException;
	public String helpText();
	
}
