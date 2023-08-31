package SplitWise.controllers;

import SplitWise.dtos.RegisterUserRequestDTO;
import SplitWise.dtos.RegisterUserResponseDTO;
import SplitWise.dtos.UpdateProfileRequestDTO;
import SplitWise.dtos.UpdateProfileResponseDTO;
import SplitWise.models.User;
import SplitWise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO request){
        User user = userService.registerUser(request.getPhoneNumber(),request.getPassword(),request.getUserName());

        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
        registerUserResponseDTO.setUser(user);
        return registerUserResponseDTO;

    }

    public UpdateProfileResponseDTO updateProfile(UpdateProfileRequestDTO registerUserRequestDTO){

        User user = userService.updateProfile(registerUserRequestDTO.getUserId(), registerUserRequestDTO.getNewPassword());
        UpdateProfileResponseDTO responseDTO = new UpdateProfileResponseDTO();
        responseDTO.setUser(user);
        return responseDTO;
    }

}
