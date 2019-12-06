package ua.biedin.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.service.impl.ArticleServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/article", produces = "application/json")
public class ArticleController {

    private final ArticleServiceImpl articleServiceImpl;

    @Autowired
    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleServiceImpl.getAllArticles();
    }
}
