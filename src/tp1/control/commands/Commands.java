package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;

public interface Commands {
	
	public void execute(Game game, GameView gameView);
	public Commands parse(String[] commands);
	public String helpText();
}
