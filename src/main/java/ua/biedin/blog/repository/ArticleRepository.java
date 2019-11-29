package ua.biedin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.repository.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findArticleById(Long id);

    Article findFirstByTitle(String title);
}
