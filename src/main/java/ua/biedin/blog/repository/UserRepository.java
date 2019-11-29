package ua.biedin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.repository.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstById(Long id);

    User findFirstByFirstName(String name);

    User findFirstByEmail(String email);
}
