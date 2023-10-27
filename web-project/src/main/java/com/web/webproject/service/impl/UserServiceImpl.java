package com.web.webproject.service.impl;

import com.web.webproject.model.entity.Role;
import com.web.webproject.model.entity.User;
import com.web.webproject.repository.RoleRepository;
import com.web.webproject.repository.UserRepository;
import com.web.webproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Slf4j /*log lỗi*/
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(NullPointerException::new);
    }

    @Override
    public void addRole(String email, String roleName) {
        log.info("thêm role vào user");
        User user = userRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        Role role = roleRepository.findByRoleName(roleName).orElseThrow(NullPointerException::new);
        user.getRoles().add(role);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
