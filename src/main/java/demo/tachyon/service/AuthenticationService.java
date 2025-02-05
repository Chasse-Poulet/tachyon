package demo.tachyon.service;

import demo.tachyon.dto.LoginUserDTO;
import demo.tachyon.dto.RegisterUserDTO;
import demo.tachyon.model.User;

public interface AuthenticationService {
    User signup(RegisterUserDTO input);

    User authenticate(LoginUserDTO input);
}
