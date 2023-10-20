package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "parent_category")
    private int parentCategory;
    private String name;
    private String description;
    private String slug;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

}
