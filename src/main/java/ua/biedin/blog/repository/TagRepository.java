package ua.biedin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.repository.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findFirstById(Long id);

    Tag findFirstByName(String name);
}
