package com.web.webproject.controller;

import com.web.webproject.model.entity.User;
import com.web.webproject.model.response.BaseResponse;
import com.web.webproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public BaseResponse<?> getUser(@RequestBody User user){
        return BaseResponse.builder().data(userService.getUsers()).build();
    }
    @PostMapping
    public BaseResponse<?> createUser(@RequestBody User user) {
        return BaseResponse.builder().data(userService.saveUser(user)).build();
    }

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable Integer id) {
//        return userService.getUserById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//    }
}
 