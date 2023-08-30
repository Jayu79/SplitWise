package SplitWise.commands;

import java.util.Arrays;
import java.util.List;

public class UpdateProfileCommand implements Command{

    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if(commandTokens.size()!=3){
            System.out.println("This is not a Update Profile command");
            return false;
        }

        if(!commandTokens.get(1).equalsIgnoreCase(CommandKeywords.UPDATE_PROFILE_COMMAND)){
            System.out.println("This is not a Update Profile command");
            return false;
        }

//        Similarly we can add multiple checks to check the command
        System.out.println("This is a Update Profile command");
        return true;
    }

    @Override
    public void execute(String commandLine) {

    }
}
