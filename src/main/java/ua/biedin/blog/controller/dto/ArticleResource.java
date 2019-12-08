package ua.biedin.blog.controller.dto;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.repository.entity.ArticleStatus;
import ua.biedin.blog.repository.entity.Categories;
import ua.biedin.blog.repository.entity.User;

import java.sql.Timestamp;

@Getter
@Relation(value = "article", collectionRelation = "articles")
public class ArticleResource extends RepresentationModel<ArticleResource> {
    private String title;
    private String description;
    private String content;
    private Categories categories;
    private User author;
    private ArticleStatus status;
    private Timestamp create;

    public ArticleResource(Article article) {
        this.title = article.getTitle();
        this.description = article.getDescription();
        this.content = article.getContent();
        this.categories = article.getCategories();
        this.author = article.getAuthor();
        this.status = article.getStatus();
        this.create = article.getCreate();
    }
}

