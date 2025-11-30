
package tp1.control;

import tp1.control.commands.Command;
import tp1.control.commands.CommandGenerator;
import tp1.exceptions.CommandException;
import tp1.logic.Game;
import tp1.view.GameView;

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
	 * @throws CommandParseException 
	 */
	public void run() {
		String[] words = null;
		view.showWelcome();
		view.showGame();
		
		/*while (!game.isFinished()) {
			try {
				String[] words = view.getPrompt();
				Command command = CommandGenerator.parse(words);
				
				command.execute(game, view);				
			}
			catch(CommandException e) {
				System.err.print(e.getMessage());
				Throwable wrapped = e;
				
				while((wrapped = wrapped.getCause()) != null) {
					System.err.print(wrapped.getMessage());
				}
			}
		}*/
		while(!game.isFinished()) {
			words = view.getPrompt();
			Command command = null;
			
			try {
				command = CommandGenerator.parse(words);
			} catch(CommandException e) {
				view.showError(e.getMessage());
				Throwable wrapped = e;
				
				// display all levels of error message
				while ((wrapped = wrapped.getCause()) != null) {
					view.showError(wrapped.getMessage());					
				}
			}
			
			
			if(command != null) {
				try{
					command.execute(game, view);
				} catch(CommandException e) {
					view.showError(e.getMessage());
					Throwable wrapped = e;
					
					// display all levels of error message
					while ((wrapped = wrapped.getCause()) != null) {
						view.showError(wrapped.getMessage());						
					}
				}
			}
		}
		view.showEndMessage();
	}
}

