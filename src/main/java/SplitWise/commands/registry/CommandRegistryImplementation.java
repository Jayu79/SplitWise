package SplitWise.commands.registry;

import SplitWise.commands.Command;
import SplitWise.commands.CommandKeywords;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistryImplementation implements CommandRegistry{

    private List<Command> commands = new ArrayList<>();
    @Override
    public void registerCommand(Command command) {
        commands.add(command);
    }

    @Override
    public Command getCommand(String commandLine) {
        for(Command command: commands){
            if(command.parse(commandLine)){
                return command;
            }
        }
        return null;
    }

    @Override
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    @Override
    public boolean executeCommandLine(String commandLine) {
        for(Command command: commands){
            if(command.parse(commandLine)){
                command.execute(commandLine);
                return true;
            }
        }
        return false;
    }
}
