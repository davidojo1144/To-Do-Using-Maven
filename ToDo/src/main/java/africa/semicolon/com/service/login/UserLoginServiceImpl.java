package africa.semicolon.com.service.login;

import africa.semicolon.com.dto.request.UserLoginRequest;
import africa.semicolon.com.model.User;
import africa.semicolon.com.repository.UserRepo;
import africa.semicolon.com.service.harshpassword.TheHarshPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TheHarshPassword theHarshPassword;

    @Override
    public String login(UserLoginRequest userLoginRequest) {
        User user = userRepo.findByUsername(userLoginRequest.getUsername());
//        System.out.println(userRepo.count());
//        System.out.println(userRepo.findAll());
//        System.out.println(userRepo.findByUsername(userLoginRequest.getUsername()));
        if (user == null) throw new IllegalArgumentException("User not found");
       // System.out.println(user.getFirstName() + " " + user.getLastName());
        if(!theHarshPassword.verifyPassword(userLoginRequest.getPassword(), user.getPassword())) throw new IllegalArgumentException("Wrong Password");
        return user.getUsername() + " Logged in Successful";
    }
}
