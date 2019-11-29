package ua.biedin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.service.impl.ArticleServiceImpl;

import java.util.List;

@RestController
public class ArticleController {
    private final ArticleServiceImpl articleServiceImpl;

    @Autowired
    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    @GetMapping("api/v1/article")
    public List<Article> getAllArticles() {
        return articleServiceImpl.getAllArticles();
    }

}
