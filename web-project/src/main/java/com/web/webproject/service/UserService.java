package com.web.webproject.service;

import com.web.webproject.model.entity.Role;
import com.web.webproject.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    User getUser(String email);
    void addRole(String email, String roleName);
    List<User> getUsers();
    void delete(Integer id);
}
