package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.dto.CategoryDto;
import com.trackingsys.stocktrackingsys.dto.converter.CategoryDtoConverter;
import com.trackingsys.stocktrackingsys.model.Category;
import com.trackingsys.stocktrackingsys.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    public CategoryDto addCategory(Category category) {
        return categoryDtoConverter.convertToDto(categoryRepository.save(category));
    }

    public List<CategoryDto> getAllCategories() {
        return categoryDtoConverter.convertToDto(categoryRepository.findAll());
    }

    public CategoryDto getByCategoryId(int categoryId) {
        return categoryDtoConverter.convertToDto(categoryRepository.findById(categoryId).orElse(null));
    }

    public Category deletedCategory(int categoryId){
        Category category = categoryRepository.findById(categoryId).orElse(null);
        categoryRepository.deleteById(categoryId);
        return category;
    }

    public CategoryDto updateCategoryById(Category category, int categoryId) {
        Category updateCategory = categoryRepository.findById(categoryId).orElse(null);
        updateCategory.setCategoryName(category.getCategoryName());
        return categoryDtoConverter.convertToDto(categoryRepository.save(updateCategory));
    }
}
