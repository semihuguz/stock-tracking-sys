package com.trackingsys.stocktrackingsys.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CategoryDto {

    private String categoryName;
}
