package com.web.webproject;

import com.web.webproject.model.entity.Role;
import com.web.webproject.model.entity.User;
import com.web.webproject.repository.RoleRepository;
import com.web.webproject.repository.UserRepository;
import com.web.webproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebProjectApplication.class, args);

    }
    @Bean
    public CommandLineRunner demo(UserService userService ) {
        return (args) -> {
            userService.saveRole(Role.builder().roleName("MANAGER").build());
            userService.saveRole(Role.builder().roleName("USER").build());
            userService.saveRole(Role.builder().roleName("ADMIN").build());

            userService.saveUser(
                    User.builder().email("ngocmeu2000@gmail.com").password("123").build()
            );
            userService.saveUser(
                    User.builder().email("ngocmeu2001@gmail.com").password("123").build()
            );
            userService.saveUser(
                    User.builder().email("ngocmeu2002@gmail.com").password("123").build()
            );

            userService.addRole("ngocmeu2000@gmail.com","MANAGER");


        };
    }

}
