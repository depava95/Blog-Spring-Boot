package ua.biedin.blog.service.impl;

import org.springframework.stereotype.Component;
import ua.biedin.blog.repository.UserRepository;
import ua.biedin.blog.repository.entity.User;

@Component
public class LoginServiceImpl {

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String login, String password) {
        User user = userRepository.findFirstByEmail(login);
        return user.getPassword().equals(password);
    }
}
