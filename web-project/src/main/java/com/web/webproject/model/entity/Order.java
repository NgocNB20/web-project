package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sessionId;
    private String token;
    private Integer status;
    private Float subTotal;
    private Float itemDiscount;
    private Float tax;
    private Float shipping;
    private Float total;
    private String promo;
    private Float disCount;
    private Float grandTotal;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String country;
    private LocalDate createAt;
    private LocalDate updateAt;
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Transaction> transactions;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",name = "userId")
    @JsonIgnore
    private User user;
}
