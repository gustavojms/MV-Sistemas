package com.mv.controllers;

import com.mv.dtos.UserDto;
import com.mv.repositories.UserRepository;
import com.mv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody UserDto userDto) {
        this.userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
