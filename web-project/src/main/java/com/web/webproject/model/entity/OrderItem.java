package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private Float price;
    private Float discount;
    private Integer quantity;
    private LocalDate createAt;
    private LocalDate updateAt;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",name = "productId")
    @JsonIgnore
    private Product product;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",name = "orderId")
    @JsonIgnore
    private Order order;
}
