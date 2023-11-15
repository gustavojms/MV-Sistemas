package com.mv.services;

import com.mv.dtos.UserDto;
import com.mv.models.User;
import com.mv.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(UserDto user) {
        this.userRepository.insertUser(user.getName(), user.getCpf());
    }
}
