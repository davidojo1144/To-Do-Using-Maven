package africa.semicolon.com.service.login;

import africa.semicolon.com.dto.request.UserLoginRequest;
import africa.semicolon.com.dto.request.UserRegisterDto;
import africa.semicolon.com.repository.UserRepo;
import africa.semicolon.com.service.register.UserRegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UserLoginServiceImplTest {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        userRepo.deleteAll();
    }

    @Test
    public void testThatUserCanRegisterAndLoginSuccessfully() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("David");
        userRegisterDto.setLastName("Smith");
        userRegisterDto.setUserName("David1234");
        userRegisterDto.setPassword("Password");
        userRegisterService.register(userRegisterDto);


        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("David1234");
        userLoginRequest.setPassword("Password");
        assertEquals(userLoginRequest.getUsername() + " Logged in Successful", userLoginService.login(userLoginRequest));

    }




}
