package com.web.webproject.service;

import com.web.webproject.model.entity.User;
import com.web.webproject.model.response.BaseResponse;
import com.web.webproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BaseResponse<?> saveUser(User user) {
       return BaseResponse.builder()
               .code("ES200")
               .data(userRepository.save(user))
               .message("save user success")
               .build();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
