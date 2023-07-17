package com.web.webproject.config.security;

import com.web.webproject.model.dto.UserRoleDTO;
import com.web.webproject.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserRoleDTO> uses = userRepository.getUsersRoleByEmail(username);
        if (uses.size()>0){
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (UserRoleDTO use : uses) {
                authorities.add(new SimpleGrantedAuthority(use.getRoleName()));
            }
            return new User(username,uses.get(0).getPassword() ,authorities);
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
