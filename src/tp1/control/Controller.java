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
		view.showWelcome();
		view.showGame();
		
		String[] inputs;	
		inputs = view.getPrompt();	
		
		inputs[0] = inputs[0].toLowerCase();	 
		
		while(!game.playerLoses() && !game.playerWins() &&
				!inputs[0].equals(Messages.COMMAND_EXIT_NAME) && !inputs[0].equals(Messages.COMMAND_EXIT_SHORTCUT)) {
			
			if(inputs.length <= 1) {
				switch(inputs[0]) {
				// update command: input length == 0 if enter is pressed or 1 if the command name/shortcut is written
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
			}
			
			if(inputs.length > 1) {
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
						view.showError(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER.formatted(String.join(" ", inputs)));
					}
					
				default:
					view.showError(Messages.UNKNOWN_COMMAND.formatted(String.join(" ", inputs)));	// shows the commands entered by the player
					break;
				}
			}
			
				inputs = view.getPrompt();	
				inputs[0] = inputs[0].toLowerCase();
			}
			
			
			view.showEndMessage();
		}

		
	}








/*public class Controller {

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
	/*public void run() {
		
		view.showWelcome();
		String[] inputs;

		// while the game has not finished (either by winning or losing) and the command is != exit or != e (shortcut)
		while(!game.playerLoses() && !game.playerWins()) {
			
			view.showGame();
			
			inputs = view.getPrompt();
			
			while (inputs.length > 1) {
				view.showError(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
				inputs = view.getPrompt();
			}

			for(int i = 0; i < inputs.length; i++)
				inputs[i] = inputs[i].toLowerCase(); // every letter is taken to lowercase so even words as "HeLp" are processed

				switch(inputs[0]) {
				case Messages.COMMAND_EXIT_NAME:
				case Messages.COMMAND_EXIT_SHORTCUT:
					break;		// if the first character is exit then go out of the while immediately?¿
				
				case Messages.COMMAND_HELP_NAME:
				case Messages.COMMAND_HELP_SHORTCUT:
					System.out.println(Messages.HELP);		
					System.out.println();	
					break;
				
				case Messages.COMMAND_RESET_NAME:
				case Messages.COMMAND_RESET_SHORTCUT:
					game.resetGame();
					view.showGame();
					break;
					
				case Messages.COMMAND_UPDATE_NAME:
				case Messages.COMMAND_UPDATE_HELP:
				case Messages.EMPTY:
					game.update();
					view.showGame();
					break;
					
				default:
					view.showError(Messages.UNKNOWN_COMMAND.formatted(inputs[0]));
					break;
				} 
				
				inputs = view.getPrompt();		// check if I can put it here without having an infinite loop
		}
		
		view.showEndMessage();
	}	
}*/
