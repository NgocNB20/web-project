package com.web.webproject.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_payment")
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "payment_type")
    private String paymentType;
    private String provider;
    @Column(name = "account_no")
    private int accountNo;
    private LocalDateTime expiry;
}
