package tn.esprit.spring.services;

import tn.esprit.spring.entities.Category;

import java.util.List;

public interface ICategoryServices {
    Category addCategory(Category category);

    List<Category> retrieveAllCategory();

    Category updateCategory(Category category);

    Category retrieveCategory(Long categoryId);
    void removeCategory (Long categoryId);

}
