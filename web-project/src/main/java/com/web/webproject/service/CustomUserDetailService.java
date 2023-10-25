package com.web.webproject.service;

import com.web.webproject.model.entity.Role;
import com.web.webproject.model.entity.User;
import com.web.webproject.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOtp = userRepository.findByEmail(username);
        if (userOtp.isPresent()) {
            List<Role> roles = userOtp.get().getRoles();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            roles.stream().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName())));
            return new org.springframework.security.core.userdetails.User(userOtp.get().getEmail(),userOtp.get().getPassword(),grantedAuthorities);
        }
        return null;
    }
}
