package com.web.webproject;

import com.web.webproject.model.entity.Role;
import com.web.webproject.model.entity.User;
import com.web.webproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class WebProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebProjectApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserService userService) {
        userService.saveRole(Role.builder().roleName("USER").build());
        userService.saveRole(Role.builder().roleName("MANAGER").build());
        userService.saveRole(Role.builder().roleName("ADMIN").build());

        userService.saveUser(
                User.builder().email("ngocmeu200@gmail1.com").build()
        );
        userService.saveUser(
                User.builder().email("ngocmeu200@gmail2.com").build()
        );
        userService.saveUser(
                User.builder().email("ngocmeu200@gmail3.com").build()
        );

        userService.addRole("ngocmeu200@gmail1.com","USER");
        userService.addRole("ngocmeu200@gmail2.com","MANAGER");
        userService.addRole("ngocmeu200@gmail3.com","ADMIN");
        userService.delete(1);

        return (args) -> {
        };
    }

}
