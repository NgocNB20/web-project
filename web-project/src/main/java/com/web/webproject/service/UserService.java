package com.web.webproject.service;

import com.web.webproject.model.entity.Role;
import com.web.webproject.model.entity.User;
import com.web.webproject.model.response.BaseResponse;
import com.web.webproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    Role saveRole(Role role);
    User getUser(String email);
    void addRole(String email, String roleName);
    List<User> getUsers();
    void delete(Integer id);
}
