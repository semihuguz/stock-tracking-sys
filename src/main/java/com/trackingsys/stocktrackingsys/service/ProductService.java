package com.trackingsys.stocktrackingsys.service;


import com.trackingsys.stocktrackingsys.dto.ProductDto;
import com.trackingsys.stocktrackingsys.dto.converter.ProductDtoConventer;
import com.trackingsys.stocktrackingsys.model.Product;
import com.trackingsys.stocktrackingsys.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDtoConventer productDtoConventer;

    public ProductService(ProductRepository productRepository, ProductDtoConventer productDtoConventer) {
        this.productRepository = productRepository;
        this.productDtoConventer = productDtoConventer;
    }

    public ProductDto addProduct(Product product) {
        return productDtoConventer.convertToDto(productRepository.save(product));

    }

    public List<ProductDto> getAllProducts() {
        return productDtoConventer.convertToDto(productRepository.findAll());
    }

    public ProductDto getProdutcById(Long productId) {
        return productDtoConventer.convertToDto(productRepository.findById(productId)
                .orElse(null));
    }

    public Product deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.deleteById(productId);
        return product;
    }

    public ProductDto updateProductById(Product product, Long productId) {
        Product updateProduct = productRepository.findById(productId).orElse(null);
        updateProduct.setProductName(product.getProductName());
        updateProduct.setUnitPrice(product.getUnitPrice());
        updateProduct.setUnitStock(product.getUnitStock());
        updateProduct.setInventory(product.getInventory());

        return productDtoConventer.convertToDto(productRepository.save(updateProduct));

    }
}
