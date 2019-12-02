package ua.biedin.blog.service.interfaces;


import ua.biedin.blog.repository.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

}
