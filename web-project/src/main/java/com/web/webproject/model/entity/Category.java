package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category {
    @OneToMany(cascade = CascadeType.ALL)  /*parentId;*/
    @JoinColumn(name = "parentId")
    List<Category> subCategories;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String metaTitle;
    private String slug;
    private String content;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategory = new ArrayList<>();

}
