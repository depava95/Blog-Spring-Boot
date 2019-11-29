package ua.biedin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.biedin.blog.entity.Article;
import ua.biedin.blog.service.ArticleService;

import java.util.List;

@RestController
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("api/v1/article")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

}
