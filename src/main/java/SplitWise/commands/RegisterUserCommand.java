package SplitWise.commands;

import SplitWise.controllers.UserController;
import SplitWise.dtos.RegisterUserRequestDTO;
import SplitWise.dtos.RegisterUserResponseDTO;
import SplitWise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegisterUserCommand implements Command{

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController){
        this.userController = userController;
    }
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
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
        String username = commandTokens.get(1);
        String phoneNumber = commandTokens.get(2);
        String password = commandTokens.get(3);
        RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
        registerUserRequestDTO.setPassword(password);
        registerUserRequestDTO.setPhoneNumber(phoneNumber);
        registerUserRequestDTO.setUserName(username);

        RegisterUserResponseDTO response = userController.registerUser(registerUserRequestDTO);
        System.out.println(response.getUser());
    }
}
