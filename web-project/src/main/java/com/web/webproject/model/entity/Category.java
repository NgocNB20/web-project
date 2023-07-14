package com.web.webproject.model.entity;

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
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "parent_id")
    private Integer parentId; /*self join*/
    private String title;
    @Column(name = "meta_title")
    private String metaTitle;
    private String slug;
    private String content;
}
