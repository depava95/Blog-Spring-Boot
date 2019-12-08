package ua.biedin.blog.service.dto;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import ua.biedin.blog.controller.ArticleController;
import ua.biedin.blog.repository.entity.Article;

public class ArticleResourceAssembler
        extends RepresentationModelAssemblerSupport<Article, ArticleResource> {

    public ArticleResourceAssembler() {
        super(ArticleController.class, ArticleResource.class);
    }

    @Override
    public ArticleResource toModel(Article article) {
        return createModelWithId(article.getId(), article);
    }

    @Override
    protected ArticleResource instantiateModel(Article article) {
        return new ArticleResource(article);
    }

    @Override
    public CollectionModel<ArticleResource> toCollectionModel(Iterable<? extends Article> articles) {
        return super.toCollectionModel(articles);
    }
}
