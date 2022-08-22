package com.trackingsys.stocktrackingsys.dto.converter;

import com.trackingsys.stocktrackingsys.dto.ProductDto;
import com.trackingsys.stocktrackingsys.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDtoConventer {

    public ProductDto convertToDto(Product product){
        return ProductDto.builder()
                .productName(product.getProductName())
                .unitStock(product.getUnitStock())
                .unitPrice(product.getUnitPrice())
                .inventory(product.getInventory())
                .stockStatus(product.isStockStatus())
                .build();
    }
    public List<ProductDto> convertToDto(List<Product> product){
        return product.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
