package tn.esprit.spring.services;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Exercice;
import tn.esprit.spring.repositories.ICategoryRespository;
import tn.esprit.spring.repositories.IExerciceRepository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServicesImpl implements ICategoryServices{
    private ICategoryRespository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> retrieveAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category retrieveCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public void removeCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
