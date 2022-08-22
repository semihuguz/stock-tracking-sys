package com.trackingsys.stocktrackingsys.controller;

import com.trackingsys.stocktrackingsys.dto.ProductDto;
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
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProductById(@PathVariable("id") Long productId){
        return ResponseEntity.ok(productService.getProdutcById(productId));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")Long productId){
        productService.deleteProduct(productId);
    }
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProductById(
            @RequestBody Product product,
            @PathVariable("id") Long productId){
        return ResponseEntity.ok(productService.updateProductById(product,productId));
    }

 }
