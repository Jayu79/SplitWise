package SplitWise.commands.registry;

import SplitWise.commands.Command;

public interface CommandRegistry {

    void registerCommand(Command command);
    Command getCommand(String commandLine);
    void removeCommand(Command command);
    boolean executeCommandLine(String commandLine);

}
