package com.web.webproject.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false, referencedColumnName = "id")
    Category category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false, referencedColumnName = "id")
    Product product;
}
