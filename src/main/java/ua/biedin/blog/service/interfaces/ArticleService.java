package ua.biedin.blog.service.interfaces;

import org.springframework.stereotype.Service;
import ua.biedin.blog.repository.entity.Article;

import java.util.List;

@Service
public interface ArticleService {

    List<Article> getAllArticles();

    Article getArticleById(Long id);
}
