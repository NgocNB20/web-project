package com.web.webproject.config.security;

import com.web.webproject.model.dto.UserDto;
import com.web.webproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.web.webproject.model.entity.User user = userRepository.findByEmail(username).get();

        List<UserDto> users = userRepository.getUsersRoleByEmail(username);
        if (users.size()>0){
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (UserDto userDTO : users) {
                authorities.add(new SimpleGrantedAuthority(""));
            }
            return new User(username,users.get(0).getPassword() ,authorities);
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
