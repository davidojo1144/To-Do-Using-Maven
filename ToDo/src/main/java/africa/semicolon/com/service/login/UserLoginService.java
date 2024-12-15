package africa.semicolon.com.service.login;

import africa.semicolon.com.dto.request.UserLoginRequest;

public interface UserLoginService {

    String login(UserLoginRequest userLoginRequest);
}
