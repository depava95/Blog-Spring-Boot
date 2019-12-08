package ua.biedin.blog.service.interfaces;


import org.springframework.data.domain.Page;
import ua.biedin.blog.repository.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Page<User> getAllUsersNotDeleted(Pageable pageable);

    Page<User> getAllUsersDeleted(Pageable pageable);

    User getUserById(Long id);

    User saveUser(User user);

    Optional<User> findUserByEmail(String email);

}
