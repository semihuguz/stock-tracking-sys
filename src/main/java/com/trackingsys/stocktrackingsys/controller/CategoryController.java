package com.trackingsys.stocktrackingsys.controller;

import com.trackingsys.stocktrackingsys.model.Category;
import com.trackingsys.stocktrackingsys.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.addCategory(category));
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());

    }
    @GetMapping("/id")
    public ResponseEntity<Category> getByCategoryId(@PathVariable("id") int categoryId){
        return ResponseEntity.ok(categoryService.getByCategoryId(categoryId));
    }
    @DeleteMapping("/id")
    public void deletedCategory(@PathVariable("id") int categoryId){
        categoryService.deletedCategory(categoryId);
    }
}
