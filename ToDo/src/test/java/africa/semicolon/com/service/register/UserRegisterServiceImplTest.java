package africa.semicolon.com.service.register;

import africa.semicolon.com.dto.request.UserRegisterDto;
import africa.semicolon.com.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserRegisterServiceImplTest {

    @Autowired
    private UserRegisterServiceImpl userRegisterService;

    @Autowired
    private UserRepo userRepo;
    @BeforeEach
    void setUp() {
        userRepo.deleteAll();
    }

    @Test
    public void testFirstUserRegistration() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("David");
        userRegisterDto.setLastName("Smith");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("David111");
        userRegisterService.register(userRegisterDto);
    }

    @Test
    public void testSecondUserRegistration() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("Daniel");
        userRegisterDto.setLastName("john");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("David222");
        userRegisterService.register(userRegisterDto);
    }

    @Test
    public void testIfUsernameAlreadyExists_NewUserShouldCreateNewUserName() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("David");
        userRegisterDto.setLastName("Smith");
        userRegisterDto.setPassword("Password");
        userRegisterDto.setUserName("David111");
        userRegisterService.register(userRegisterDto);
    }
}