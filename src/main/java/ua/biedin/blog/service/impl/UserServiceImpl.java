package ua.biedin.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.biedin.blog.exception.NoUsersAvailableException;
import ua.biedin.blog.exception.ThereIsNoSuchUserException;
import ua.biedin.blog.repository.UserRepository;
import ua.biedin.blog.repository.entity.User;
import ua.biedin.blog.service.interfaces.UserService;
import ua.biedin.blog.utils.Constants;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        if (users.isEmpty()) {
            throw new NoUsersAvailableException();
        }
        return users;
    }

    public Page<User> getAllUsersNotDeleted(Pageable pageable) {
        Page<User> users = userRepository.findAllUsersNotDeleted(pageable);
        if (users.isEmpty()) {
            throw new NoUsersAvailableException();
        }
        return users;
    }

    @Override
    public Page<User> getAllUsersDeleted(Pageable pageable) {
        Page<User> users = userRepository.findAllUsersDeleted(pageable);
        if (users.isEmpty()) {
            throw new NoUsersAvailableException();
        }
        return users;
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findFirstById(id);
        if (user.isEmpty()) {
            throw new ThereIsNoSuchUserException();
        }
        return user.get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public static Pageable createPagination(int size, int page, String sort, String direction) {
        if (direction.equals(Constants.ASC)) {
            return PageRequest.of(page, size, Sort.by(sort).ascending());
        } else {
            return PageRequest.of(page, size, Sort.by(sort).descending());
        }
    }

}