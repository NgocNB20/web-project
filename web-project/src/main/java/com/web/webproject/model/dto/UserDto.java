package com.web.webproject.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
    private Integer id;
    private String email;
    private String password;
    private String roleName;
    private Integer roleId;
    private Integer userId;
}
