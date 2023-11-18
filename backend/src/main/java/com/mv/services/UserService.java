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
        List<Object[]> results = userRepository.findAllUsers();
        List<UserDto> users = new ArrayList<>();

        for (Object[] result : results) {
            UserDto user = new UserDto();
            user.setId((Long) result[0]);
            user.setName((String) result[1]);
            user.setCpf((String) result[2]);
            users.add(user);
        }

        return users;
    }

    @Transactional
    public UserDto save(UserDto userDto) {
       userRepository.insertUser(userDto.getName(), userDto.getCpf());
       User user = userRepository.findByCpf(userDto.getCpf());
       return new UserDto(user.getId(), user.getName(), user.getCpf());
    }

    @Transactional
    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Transactional
    public UserDto updateUser(Long userId, String name, String cpf) {
        userRepository.updateUser(userId, name, cpf);
        User user = userRepository.findByCpf(cpf);
        return new UserDto(user.getId(), user.getName(), user.getCpf());
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteUser(userId);
    }
}
