package com.web.webproject.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String description;
    private String SKU;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToOne
    @JoinColumn(name = "inventory_id")
    private ProductInventory productInventory;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToOne(mappedBy = "product")
    private OderDetails oderDetails;
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private CartItem cartItem;


}
