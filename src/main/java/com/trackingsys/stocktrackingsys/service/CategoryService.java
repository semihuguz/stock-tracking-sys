package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.model.Category;
import com.trackingsys.stocktrackingsys.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category deletedCategory(int categoryId){
        Category category = categoryRepository.findById(categoryId).orElse(null);
        categoryRepository.deleteById(categoryId);
        return category;
    }
}
