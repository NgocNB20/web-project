package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "delete_at")
    private LocalDateTime deleteAt;
    @OneToMany(mappedBy = "discount",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Product> products = new ArrayList<>();
}
