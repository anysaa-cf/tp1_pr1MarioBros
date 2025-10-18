package tp1.logic;

import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand {

	  private static final String NAME = Messages.COMMAND_HELP_NAME;
	  private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	  private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	  private static final String HELP = Messages.COMMAND_HELP_HELP;

	  public HelpCommand(){
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


	  // Implementation of the execute method
}
