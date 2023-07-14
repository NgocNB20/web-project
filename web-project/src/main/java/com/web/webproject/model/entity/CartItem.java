package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_id")
    private Integer productId; /*table product*/
    @Column(name = "cart_id")
    private Integer cartId; /*table cart*/
    private String sku;
    private Float price;
    private Float discount;
    private Boolean active;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "update_at")
    private LocalDate updateAt;
    @Column(columnDefinition = "TEXT")
    private String content;
}
