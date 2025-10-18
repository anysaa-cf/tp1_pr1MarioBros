package tp1.logic;

public abstract class AbstractCommands implements Commands {
	private String name;
	private String shortcut;
	private String details;
	private String help;
	
	public AbstractCommands(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	public String getName() {
		return name;
	}
	
	public String shortcut() {
		return shortcut;
	}
	
}
