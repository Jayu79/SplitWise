package SplitWise.commands;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegisterUserCommand implements Command{

    @Override
    public boolean parse(String commandLine) {

        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if(commandTokens.size()!=4){
            System.out.println("This is not a Register User command");
            return false;
        }

        if(!commandTokens.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER_COMMAND)){
            System.out.println("This is not a Register User command");
            return false;
        }

//        Similarly we can add multiple checks to check the command
        System.out.println("This is a Register User command");
        return true;
    }

    @Override
    public void execute(String commandLine) {



    }
}
