package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer parentId;
    private String title;
    private int ratting;
    private String published;
    private LocalDate createAt;
    private LocalDate publishedAt;
    @Column(columnDefinition = "TEXT")
    private String content;
}