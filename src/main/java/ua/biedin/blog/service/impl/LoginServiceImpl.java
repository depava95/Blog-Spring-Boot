package ua.biedin.blog.service.impl;

import org.springframework.stereotype.Component;
import ua.biedin.blog.controller.response.LoginResponse;
import ua.biedin.blog.repository.UserRepository;
import ua.biedin.blog.repository.entity.User;
import ua.biedin.blog.service.interfaces.LoginService;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final LoginResponse loginResponse;

    public LoginServiceImpl(UserRepository userRepository, LoginResponse loginResponse) {
        this.userRepository = userRepository;
        this.loginResponse = loginResponse;
    }

    public LoginResponse login(String login, String password) {
        Optional<User> user = userRepository.findFirstByEmail(login);
        if (user.isPresent()) {
            loginResponse.setLogin(true);
            if (user.get().getPassword().equals(password)) {
                loginResponse.setPassword(true);
            }
        }
        return loginResponse;
    }
}
