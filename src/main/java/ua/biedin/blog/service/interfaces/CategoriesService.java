package ua.biedin.blog.service.interfaces;

import ua.biedin.blog.repository.entity.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> getAllCategories();
}
