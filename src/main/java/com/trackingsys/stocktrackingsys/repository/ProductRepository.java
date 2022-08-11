package com.trackingsys.stocktrackingsys.repository;

import com.trackingsys.stocktrackingsys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
