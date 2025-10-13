package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;
import tp1.logic.Action;

/**
 *  Accepts user input and coordinates the game execution logic
 */


public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		boolean exit = false;
		
		view.showWelcome();
		view.showGame();
		
		String[] inputs = view.getPrompt();	
		for(int i = 0; i < inputs.length; i++)
			inputs[i] = inputs[i].toLowerCase();	 
		
		while(!game.playerLoses() && !game.playerWins() && !exit) {
			
			// input length == 0 if enter is pressed or 1 if the command name/shortcut is written
			if(inputs.length <= 1) {
				switch(inputs[0]) {
				// update command: 
				case Messages.COMMAND_UPDATE_NAME:
				case Messages.COMMAND_UPDATE_SHORTCUT:
				case Messages.EMPTY:
					game.update();
					view.showGame();
					break;
						
				// help command:
				case Messages.COMMAND_HELP_NAME:
				case Messages.COMMAND_HELP_SHORTCUT:
					System.out.println(Messages.HELP);
					System.out.println();
					break;
				
				// exit command:
				case Messages.COMMAND_EXIT_NAME:
				case Messages.COMMAND_EXIT_SHORTCUT:
					exit = true;
					break;
					
				// reset command: when no numLevel is specified
				case Messages.COMMAND_RESET_NAME:
				case Messages.COMMAND_RESET_SHORTCUT:
					game.resetGame();
					view.showGame();
					break;
					
				default:
					view.showError(Messages.UNKNOWN_COMMAND.formatted(String.join(" ", inputs)));	// shows the commands entered by the player
					break;
				}
			} else {		// inputs.length > 1
				switch(inputs[0]) {
				
				// reset command: when numLevel is specified
				case Messages.COMMAND_RESET_NAME:
				case Messages.COMMAND_RESET_SHORTCUT:
					
					if(inputs[1].matches("[0-9]+")) {
						int levelSpecified = Integer.parseInt(inputs[1]);
						if(levelSpecified == 0 || levelSpecified == 1) {
							game.resetGameWithLevel(levelSpecified);						
							view.showGame();
							break;					
						} else {
							view.showError(Messages.INVALID_LEVEL_NUMBER);
						}						
					} else {
						// if the player puts a string instead of a numLevel
						view.showError(Messages.LEVEL_NOT_A_NUMBER);
					}
					
				case Messages.COMMAND_ACTION_NAME:
				case Messages.COMMAND_ACTION_SHORTCUT:
					
					boolean ok = true;
					Action[] actionList = new Action[inputs.length - 1];
					int i = 1;
					
					while(ok && i < inputs.length) {
						
						switch(inputs[i]) {
					
						case Messages.ACTION_RIGHT:
						case Messages.ACTION_RIGHT_SHORTCUT:
							actionList[i++ - 1] = Action.RIGHT;
							break;
							
						
						case Messages.ACTION_LEFT:
						case Messages.ACTION_LEFT_SHORTCUT:
							actionList[i++ - 1] = Action.LEFT;
							break;
						
						case Messages.ACTION_UP:
						case Messages.ACTION_UP_SHORTCUT:
							actionList[i++ - 1] = Action.UP;
							break;
						
						case Messages.ACTION_DOWN:
						case Messages.ACTION_DOWN_SHORTCUT:
							actionList[i++ - 1] = Action.DOWN;
							break;
					
						default:
							ok = false;
							view.showError(Messages.UNKNOWN_COMMAND.formatted(String.join(" ", inputs)));	// shows the commands entered by the player
							break;
						}
						
					}
						break;
					
				default:
					view.showError(Messages.UNKNOWN_COMMAND.formatted(String.join(" ", inputs)));	// shows the commands entered by the player
					break;
				}
				view.showGame();
			}
				
			if(!exit) {
				inputs = view.getPrompt();	
				for(int i = 0; i < inputs.length; i++)
					inputs[i] = inputs[i].toLowerCase();
			}
		}
				
		view.showEndMessage();
	}

}









