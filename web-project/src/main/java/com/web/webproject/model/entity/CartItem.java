package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_item")
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private ShoppingSession shoppingSession;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
