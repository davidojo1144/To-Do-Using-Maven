package africa.semicolon.com.service.register;

import africa.semicolon.com.dto.request.UserRegisterDto;
import africa.semicolon.com.model.User;
import africa.semicolon.com.repository.UserRepo;
import africa.semicolon.com.service.harshpassword.TheHarshPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private TheHarshPassword theHarshPassword;

    @Autowired
    private UserRepo userRepo;

    @Override
    public String register(UserRegisterDto userRegisterDto) {
        if(userRegisterDto.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        if(userRegisterDto.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be blank");
        if(userRegisterDto.getUserName().isBlank()) throw new IllegalArgumentException("Username cannot be blank");
        if(userRegisterDto.getUserName().length() < 6)  throw new IllegalArgumentException("Username must be at least 6 characters");
        if(userRegisterDto.getPassword().length() < 8) throw new IllegalArgumentException("Password must be at least 8 characters");
        if(userRegisterDto.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be blank");
        if(!Character.isUpperCase(userRegisterDto.getPassword().charAt(0))) throw new IllegalArgumentException("Password must be upper case letter");
        if(userRepo.existsById(userRegisterDto.getUserName())) throw new IllegalArgumentException("Username already exists");


        User user = new User();
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setUsername(userRegisterDto.getUserName());
        user.setPassword(theHarshPassword.harshPassword(userRegisterDto.getPassword()));
        userRepo.save(user);
        return "Registration Successful";


    }
}
