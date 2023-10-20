package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_session")
public class ShoppingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double total;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @OneToMany(mappedBy = "shoppingSession",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();
}
