package com.trackingsys.stocktrackingsys.service;


import com.trackingsys.stocktrackingsys.model.Product;
import com.trackingsys.stocktrackingsys.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProdutcById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.deleteById(productId);
        return product;
    }

    public Product updateProductById(Product product, Long productId) {
        Product updateProduct = productRepository.findById(productId).orElse(null);
        updateProduct.setProductName(product.getProductName());
        updateProduct.setUnitPrice(product.getUnitPrice());
        updateProduct.setUnitStock(product.getUnitStock());
        updateProduct.setInventory(product.getInventory());

        return productRepository.save(updateProduct);

    }
}
