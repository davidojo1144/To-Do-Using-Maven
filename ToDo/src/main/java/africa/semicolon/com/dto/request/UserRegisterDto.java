package africa.semicolon.com.dto.request;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
