package com.mv.services;

import com.mv.dtos.ItemOptionDto;
import com.mv.dtos.UserDto;
import com.mv.models.ItemOption;
import com.mv.models.User;
import com.mv.repositories.ItemOptionRepository;
import com.mv.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Transactional
    public void updateUserName(Long userId, String name) {
        userRepository.updateUserName(userId, name);
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteUser(userId);
    }
}
