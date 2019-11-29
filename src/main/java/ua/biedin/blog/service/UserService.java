package ua.biedin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.entity.User;
import ua.biedin.blog.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById (Long id) {
        return userRepo.findFirstById(id);
    }

    public void saveUser (User user) {
        userRepo.save(user);
    }
}
