package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Cart> Carts = new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();

}
