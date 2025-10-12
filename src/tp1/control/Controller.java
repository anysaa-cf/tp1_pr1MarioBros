package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

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
		inputs[0] = inputs[0].toLowerCase();	 
		
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
				// action command:
				case Messages.COMMAND_ACTION_NAME:
				case Messages.COMMAND_ACTION_SHORTCUT:
					System.out.println("performing actions");
					view.showGame();
					break;
				
				// reset command: when numLevel is specified
				case Messages.COMMAND_RESET_NAME:
				case Messages.COMMAND_RESET_SHORTCUT:
					int levelSpecified = Integer.parseInt(inputs[1]);
					if(levelSpecified == 0 || levelSpecified == 1) {
						game.resetGameWithLevel(levelSpecified);						
						view.showGame();
						break;					
					} else {
						view.showError(Messages.INVALID_LEVEL_NUMBER);
					}
					
				default:
					view.showError(Messages.UNKNOWN_COMMAND.formatted(String.join(" ", inputs)));	// shows the commands entered by the player
					break;
				}
			}
				
			if(!exit) {
				inputs = view.getPrompt();	
				inputs[0] = inputs[0].toLowerCase();
			}
		}
				
		view.showEndMessage();
	}

}









