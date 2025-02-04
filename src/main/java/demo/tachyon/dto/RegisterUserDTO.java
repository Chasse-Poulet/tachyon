package demo.tachyon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    private String email;
    private String displayName;
    private String password;
    private String fullName;
}
