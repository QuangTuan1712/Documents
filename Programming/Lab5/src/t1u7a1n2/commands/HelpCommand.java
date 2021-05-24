package t1u7a1n2.commands;

import java.util.Map;

/**
 * Command displays help for available commands
 */
public class HelpCommand extends CommandWithoutArgs{
	private Map<String, Command> commands;
	
	public HelpCommand(Map<String, Command> commands) {
		super("help", "display help for available commands");
		this.commands = commands;
	}
	
	@Override
	public String doRun() {
		StringBuilder string = new StringBuilder();
        string.append("List of commands: \n");
        for(Command command: commands.values()){
            string.append("    ").append(command.getName()).append(" : ").append(command.getDescription()).append("\n");
        }
        return string.toString();
	}
}
