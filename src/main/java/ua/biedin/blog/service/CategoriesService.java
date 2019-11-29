package ua.biedin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.entity.Categories;
import ua.biedin.blog.repository.CategoryRepo;

import java.util.List;

@Service
public class CategoriesService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoriesService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Categories> getAllCategories() {
       return categoryRepo.findAll();
    }
}
