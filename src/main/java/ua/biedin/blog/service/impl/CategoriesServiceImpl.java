package ua.biedin.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.repository.entity.Categories;
import ua.biedin.blog.repository.CategoryRepository;
import ua.biedin.blog.service.interfaces.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoriesServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Categories> getAllCategories() {
       return categoryRepository.findAll();
    }
}
