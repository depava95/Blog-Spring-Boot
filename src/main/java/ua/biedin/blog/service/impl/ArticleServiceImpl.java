package ua.biedin.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.biedin.blog.repository.entity.Article;
import ua.biedin.blog.repository.ArticleRepository;
import ua.biedin.blog.service.interfaces.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Page<Article> getAllArticlesWithPagination(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    public Article getArticleById(Long id) {
        return articleRepository.findArticleById(id);
    }
}
