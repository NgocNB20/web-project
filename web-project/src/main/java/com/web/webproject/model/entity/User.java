package com.web.webproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String passwordHash;
    private Integer admin;
    private Integer vendor;
    private LocalDateTime registeredAt;
    private LocalDateTime lastLogin;
    @Column(columnDefinition = "TEXT")
    private String intro;
    @Column(columnDefinition = "TEXT")
    private String profile;

    private String username;
    private String password;
    private Integer roleId;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
