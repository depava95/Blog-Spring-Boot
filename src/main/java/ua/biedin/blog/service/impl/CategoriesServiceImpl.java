package ua.biedin.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.repository.entity.Categories;
import ua.biedin.blog.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoriesServiceImpl {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoriesServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Categories> getAllCategories() {
       return categoryRepository.findAll();
    }
}
