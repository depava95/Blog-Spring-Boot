package ua.biedin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.repository.entity.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
    Categories findFirstById(Long id);

    Categories findFirstByArticleName(String name);
}
