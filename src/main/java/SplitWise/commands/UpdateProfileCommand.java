package SplitWise.commands;

import SplitWise.controllers.UserController;
import SplitWise.dtos.UpdateProfileRequestDTO;
import SplitWise.dtos.UpdateProfileResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UpdateProfileCommand implements Command{

    private UserController userController;

    @Autowired
    public UpdateProfileCommand(UserController userController){
        this.userController = userController;
    }

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
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
        Long userId = Long.parseLong(commandTokens.get(0));
        String newPassword = commandTokens.get(2);

        UpdateProfileRequestDTO requestDTO = new UpdateProfileRequestDTO();
        requestDTO.setNewPassword(newPassword);
        requestDTO.setUserId(userId);

        UpdateProfileResponseDTO responseDTO = userController.updateProfile(requestDTO);

        System.out.println(responseDTO.getUser());
    }
}
