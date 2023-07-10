package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "productId",referencedColumnName = "id")
    private Product product;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "tagId",referencedColumnName = "id")
    private Tag tag;
}
