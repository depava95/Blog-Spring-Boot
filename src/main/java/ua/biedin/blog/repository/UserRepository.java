package ua.biedin.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.repository.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstById(Long id);

    Optional<User> findFirstByFirstName(String name);

    Optional<User> findFirstByEmail(String email);

    @Query(value = "SELECT * FROM users u WHERE u.is_deleted = 0", nativeQuery = true)
    Page<User> findAllUsersNotDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM users u WHERE u.is_deleted = 1", nativeQuery = true)
    Page<User> findAllUsersDeleted(Pageable pageable);

}
