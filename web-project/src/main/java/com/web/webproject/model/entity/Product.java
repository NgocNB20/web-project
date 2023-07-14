package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    private String title;
    @Column(name = "meta_title")
    private String metaTitle;
    private String slug;
    private Long summary;
    private Integer type;
    private String sku;
    private Float price;
    private Float discount;
    private Integer quantity;
    private Integer shop;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "update_at")
    private LocalDate updateAt;
    private LocalDate published;
    @Column(name = "start_at")
    private LocalDate startAt;
    @Column(name = "end_at")
    private LocalDate endAt;
    private String context;

}
