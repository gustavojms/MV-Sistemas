package com.mv.controllers;

import com.mv.dtos.CoffeeDayDto;
import com.mv.models.CoffeeDay;
import com.mv.services.CoffeeDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/coffee-day")
public class CoffeeDayController {

    @Autowired
    private CoffeeDayService coffeeDayService;

    @PostMapping("/create")
    public ResponseEntity<String> createCoffeDay(@RequestBody CoffeeDayDto coffeDayDto) {
        coffeeDayService.insertCoffeeDay(coffeDayDto);
        return ResponseEntity.ok("Um novo CoffeDay foi criado com sucesso!");
    }

    @GetMapping("/all")
    public ResponseEntity<String> findAllCoffeeDays() {
        return ResponseEntity.ok(coffeeDayService.findAllCoffeeDays().toString());
    }
}
