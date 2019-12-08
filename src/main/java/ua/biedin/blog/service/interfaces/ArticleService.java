package ua.biedin.blog.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.biedin.blog.repository.entity.Article;

import java.util.List;

@Service
public interface ArticleService {

    Page<Article> getAllArticlesWithPagination(Pageable pageable);

    Article getArticleById(Long id);
}
