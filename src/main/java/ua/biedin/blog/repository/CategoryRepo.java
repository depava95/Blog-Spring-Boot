package ua.biedin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.entity.Categories;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long> {
    Categories findFirstById(Long id);

    Categories findFirstByArticleName(String name);
}
