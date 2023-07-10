package com.web.webproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer type;
    private Integer model;
    private Integer status;
    private LocalDate createAt;
    private LocalDate updateAt;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "orderId")
    @JsonIgnore
    private Order order;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id") /*FK*/
    private User user;
}
