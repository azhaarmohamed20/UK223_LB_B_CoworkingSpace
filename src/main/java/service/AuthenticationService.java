package service;

import dto.LoginUserDto;
import dto.RegisterUserDto;
import jakarta.transaction.Transactional;
import model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(RegisterUserDto registerUserDto) {
        // Überprüfen, ob es bereits Benutzer gibt
        boolean isFirstUser = userRepository.count() == 0;

        User user = new User();
        user.setEmail(registerUserDto.getEmail());
        user.setFirstName(registerUserDto.getFirstName());
        user.setLastName(registerUserDto.getLastName());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        // Setze die Rolle basierend darauf, ob es der erste Benutzer ist
        user.setRole(isFirstUser ? "ADMIN" : "MEMBER");

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
