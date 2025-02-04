package demo.tachyon.service;

import demo.tachyon.dto.LoginUserDTO;
import demo.tachyon.dto.RegisterUserDTO;
import demo.tachyon.model.User;
import demo.tachyon.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDTO input) {
        User user = User.from(input);
        user.setPassword(bCryptPasswordEncoder.encode(input.getPassword()));

        // The first user to sign up is the admin, then every user starts as a regular user
        user.setRoles(Set.of("ROLE_USER"));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getDisplayName(),
                        input.getPassword()
                )
        );

        return userRepository.findByDisplayName(input.getDisplayName()).orElseThrow();
    }
}
