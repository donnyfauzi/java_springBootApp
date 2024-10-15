package com.example.myApp.service;

import com.example.myApp.model.user;
import com.example.myApp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    public Optional<user> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(user user) {
        userRepository.save(user);
    }
    
}
