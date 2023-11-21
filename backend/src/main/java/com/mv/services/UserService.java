package com.mv.services;

import com.mv.dtos.ItemOptionDto;
import com.mv.dtos.UserDto;
import com.mv.models.ItemOption;
import com.mv.models.User;
import com.mv.repositories.ItemOptionRepository;
import com.mv.repositories.UserRepository;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {


    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserDto> findAll() {
        List<User> results = userRepository.findAllUsers();
        List<UserDto> users = new ArrayList<>();

        for (User user : results) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getUserId());
            userDto.setName(user.getName());
            userDto.setCpf(user.getCpf());
            users.add(userDto);
        }

        return users;
    }

    @Transactional
    public UserDto save(UserDto userDto) {
       userRepository.insertUser(userDto.getName(), userDto.getCpf());
       User user = userRepository.findByCpf(userDto.getCpf());
       return new UserDto(user.getUserId(), user.getName(), user.getCpf());
    }

    @Transactional
    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Transactional
    public UserDto updateUser(Long userId, String name, String cpf) {
        userRepository.updateUser(userId, name, cpf);
        User user = userRepository.findByCpf(cpf);
        return new UserDto(user.getUserId(), user.getName(), user.getCpf());
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteUser(userId);
    }
}
