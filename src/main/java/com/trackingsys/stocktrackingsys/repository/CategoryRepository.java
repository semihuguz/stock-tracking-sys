package com.trackingsys.stocktrackingsys.repository;

import com.trackingsys.stocktrackingsys.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
