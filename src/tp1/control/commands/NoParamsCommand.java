package tp1.control.commands;

public abstract class NoParamsCommand extends AbstractCommands{

	private String name;
	private String shortcut;
	private String details;
	private String help;
	
	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	public void parse() { // not sure if it's void or Commands type
		
	}
	
	public String helpText() {
		return " ";
	}
	
}
