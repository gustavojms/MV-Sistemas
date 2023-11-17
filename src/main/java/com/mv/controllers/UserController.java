package com.mv.controllers;

import com.mv.dtos.UserDto;
import com.mv.models.User;
import com.mv.repositories.UserRepository;
import com.mv.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> insert(@Valid @RequestBody UserDto userDto) {
        this.userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("O usuário foi cadastrado com sucesso!");
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<User> findByCpf(@PathVariable String cpf) {
        User user = userService.findByCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserName(@PathVariable Long userId, @RequestParam String name) {
        userService.updateUserName(userId, name);
        return ResponseEntity.ok("Nome do usuário atualizado com sucesso!");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }
}
