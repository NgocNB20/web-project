package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OderDetails {

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double total;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @OneToMany(mappedBy = "oderDetails",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItems> orderItems;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

}
