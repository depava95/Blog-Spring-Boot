package ua.biedin.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.repository.ArticleRepository;
import ua.biedin.blog.repository.entity.QArticle;
import ua.biedin.blog.service.interfaces.ArticleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Iterable<Article> getAllArticlesWithPagination() {
        return articleRepository.findAll();
    }

    public Iterable<Article> getAllArticlesWithPagination(boolean isDeleted) {
        if (isDeleted) {
            return articleRepository.findAll(QArticle.article.isDeleted.eq(true));
        }
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findArticleById(id);
    }
}

/*
* public List<User> getByAgeExcluding(Integer minAge, Integer maxAge) {
        return Lists.newArrayList(repository.findAll(QUser.user.age.between(minAge, maxAge)));
    }*/