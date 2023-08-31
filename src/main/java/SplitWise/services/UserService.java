package SplitWise.services;

import SplitWise.models.User;
import SplitWise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User registerUser(String phoneNumber, String password, String userName){
        User user = new User();
        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);
        user.setHashedPassword(password); //Ideally we need to encrypt it internally

        User user1 = userRepository.save(user);

        return user1;
    }

}
