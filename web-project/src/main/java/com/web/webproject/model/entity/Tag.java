package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String metaTitle;
    private String slug;
    @Column(columnDefinition = "TEXT")
    private String content;
    @OneToMany(mappedBy ="tag",cascade = CascadeType.ALL)
    private List<ProductTag> productTags;
}
