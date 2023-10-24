package com.web.webproject.config.security;

import com.web.webproject.model.dto.UserDto;
import com.web.webproject.model.entity.Role;
import com.web.webproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;
import com.web.webproject.model.entity.User;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOtp = userRepository.findByEmail(email);
        if (userOtp.isPresent()){
            List<GrantedAuthority> authorities = new ArrayList<>();
            userOtp.get().getRoles().forEach(role->{
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            });
            return new org.springframework.security.core.userdetails.User(userOtp.get().getUsername(),userOtp.get().getPassword() ,authorities);
        }
        else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }

}
