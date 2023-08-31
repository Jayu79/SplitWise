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

    public User updateProfile(Long userId, String newPassword){
//        Written the update profile function to update only password. We can also extend the same function to update multiple fields
        User user = userRepository.findUserById(userId);
        user.setHashedPassword(newPassword);
        User savedUser = userRepository.save(user);

        return savedUser;
    }


}
