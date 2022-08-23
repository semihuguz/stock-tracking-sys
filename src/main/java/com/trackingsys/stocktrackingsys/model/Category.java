package com.trackingsys.stocktrackingsys.model;

import lombok.*;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    /*@OneToMany(mappedBy = "category")
    private List<Product> products;*/


}
