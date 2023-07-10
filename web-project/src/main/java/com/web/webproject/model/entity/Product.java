package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String metaTitle;
    private String slug;
    private Long summary;
    private Integer type;
    private String sku;
    private Float price;
    private Float discount;
    private Integer quantity;
    private Integer shop;
    private LocalDate createAt;
    private LocalDate updateAt;
    private LocalDate published;
    private LocalDate startAt;
    private LocalDate endAt;
    private String context;
    @OneToMany(mappedBy ="product",cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories = new ArrayList<>();
    @OneToMany(mappedBy ="product",cascade = CascadeType.ALL)
    private List<ProductReview> productReviews;
    @OneToMany(mappedBy ="product",cascade = CascadeType.ALL)
    private List<ProductMeta> productMetas;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id")
    private User user;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn()

}
