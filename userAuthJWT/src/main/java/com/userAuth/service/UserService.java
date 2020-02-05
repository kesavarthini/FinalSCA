package com.userAuth.service;

import com.userAuth.model.User;
import com.userAuth.payload.ApiResponse;
import com.userAuth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ApiResponse getAllUsers() {
        log.info("=== started listing all the users ===");
        List<User> users = this.userRepository.findAll();
        if (!users.isEmpty()){
            return new ApiResponse(users, true, "");
        }
        log.info("=== successfully fetched the sonimGroup list ===");
        return null;
    }
}
