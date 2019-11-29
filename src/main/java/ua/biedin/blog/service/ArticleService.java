package ua.biedin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.entity.Article;
import ua.biedin.blog.repository.ArticleRepo;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepo articleRepo;

    @Autowired
    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepo.findArticleById(id);
    }
}
