package ua.biedin.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.service.impl.ArticleServiceImpl;


@Slf4j
@RestController
@RequestMapping(path = "api/v1/article", produces = "application/json")
public class ArticleController {

    private final ArticleServiceImpl articleServiceImpl;
    @Autowired
    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }


    // get one article
    // get all article with pagination

    @GetMapping
    public Iterable<Article> getAll(@RequestParam(required = false) boolean isDeleted) {
        return articleServiceImpl.getAllArticlesWithPagination(isDeleted);
    }
}
