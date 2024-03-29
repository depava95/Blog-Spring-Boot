package ua.biedin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.repository.entity.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findFirstById(Long id);

    List<Comment> findByArticle(Article article);
}
