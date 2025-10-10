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
		
//		boolean exit = false;
		
		view.showWelcome();
		view.showGame();
		
		String[] inputs;	// for the commands
		String[] inputs2;	// for the additional info that a command might have (reset or action)
		inputs = view.getPrompt();		// reads Command> whatever
		
		if (inputs.length > 1) {		
			view.showError(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		}
		
		inputs[0] = inputs[0].toLowerCase();		// identifies uppercase / lowercase and converts it to lowercase 
		
		// while the game has not finished (either by winning or losing) and the command is != exit or != e (shortcut)
		while(!game.playerLoses() && !game.playerWins() &&
				!inputs[0].equals(Messages.COMMAND_EXIT_NAME) && !inputs[0].equals(Messages.COMMAND_EXIT_SHORTCUT)) {
			
			
			if(inputs.length == 0 || inputs[0].isEmpty()) {		// should be the update command?¿
//				game.update();
				view.showGame();
			}
			
			if(inputs.length == 1) {
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
//	[r]eset [numLevel]: reset the game to initial configuration if not numLevel else load the numLevel map
					int level;
					level = Integer.parseInt(inputs[1]);	// convert the string level input into an int 
					
					game.resetGame(level);
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
			
			
		}

		
		view.showEndMessage();
	}

}
