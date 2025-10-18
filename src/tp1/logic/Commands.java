package tp1.logic;

import tp1.view.GameView;

public interface Commands {
	
	public void execute(Game game, GameView gameView);
	public Commands parse(String[] commands);
	public String helpText();
}
