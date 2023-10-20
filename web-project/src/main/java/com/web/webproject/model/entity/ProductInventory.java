package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_inventory")
public class ProductInventory {

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
    @OneToOne(mappedBy = "productInventory")
    private Product product;
}
