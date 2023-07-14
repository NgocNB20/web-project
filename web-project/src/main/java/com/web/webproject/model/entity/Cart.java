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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId; /*table user*/
    @Column(name = "session_id")
    private String sessionId;
    private String token;
    private Integer status;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    private String mobile;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String country;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "update_at")
    private LocalDate updateAt;
    @Column(columnDefinition = "TEXT")
    private String content;

}
