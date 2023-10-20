package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OderDetails oderDetails;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

}
