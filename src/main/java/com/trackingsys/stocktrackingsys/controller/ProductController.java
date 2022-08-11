package com.trackingsys.stocktrackingsys.controller;

import com.trackingsys.stocktrackingsys.model.Product;
import com.trackingsys.stocktrackingsys.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product>getProductById(@PathVariable("id") Long productId){
        return ResponseEntity.ok(productService.getProdutcById(productId));
    }
 }
