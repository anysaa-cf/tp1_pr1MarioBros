package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand {

	  private static final String NAME = Messages.COMMAND_EXIT_NAME;
	  private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	  private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
	  private static final String HELP = Messages.COMMAND_EXIT_HELP;

	  public ExitCommand(){
	  	super(NAME, SHORTCUT, DETAILS, HELP);
	  }
	  
	  protected boolean matchCommand(String command) {
			boolean ok = false;
			
			return ok;
	  }
	  
	  public Commands parse(String[] commands) {
		  Commands command = null;
		  
		  return command;
	  }
	
	 public void execute(Game game, GameView gameView) {
		
	  }
	
	  public String helpText() {
		return DETAILS + ": " + HELP;
	  }


}
