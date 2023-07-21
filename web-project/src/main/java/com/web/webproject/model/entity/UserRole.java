package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "user_id")
    private Integer userId;


}
