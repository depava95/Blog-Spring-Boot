package ua.biedin.blog.service.interfaces;


import ua.biedin.blog.repository.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User saveUser(User user);

    Optional<User> findUserByEmail(String email);

}
