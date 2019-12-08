package ua.biedin.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.service.dto.ArticleResource;
import ua.biedin.blog.service.dto.ArticleResourceAssembler;
import ua.biedin.blog.service.impl.ArticleServiceImpl;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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
    public ResponseEntity<CollectionModel<ArticleResource>> getAllArticlesWithPagination() {
        PageRequest page = PageRequest.of(0, 5, Sort.by("create").descending());
        Page<Article> articleList = articleServiceImpl.getAllArticlesWithPagination(page);
        CollectionModel<ArticleResource> articleResources = new ArticleResourceAssembler().toCollectionModel(articleList);
        articleResources.add(linkTo(methodOn(ArticleController.class).getAllArticlesWithPagination())
                .withRel("articles"));
        return new ResponseEntity<>(articleResources, HttpStatus.OK);
    }
}
