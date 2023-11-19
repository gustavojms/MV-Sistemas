package com.mv.controllers;

import com.mv.dtos.CoffeeDayDto;
import com.mv.models.CoffeeDay;
import com.mv.services.CoffeeDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/coffee-day")
@CrossOrigin(origins = "*")
public class CoffeeDayController {

    @Autowired
    private CoffeeDayService coffeeDayService;

    @PostMapping
    public ResponseEntity<CoffeeDayDto> createCoffeDay(@RequestBody CoffeeDayDto coffeDayDto) {
        CoffeeDayDto coffeeDay = coffeeDayService.insertCoffeeDay(coffeDayDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(coffeeDay);
    }

    @GetMapping
    public ResponseEntity<List<CoffeeDayDto>> findAllCoffeeDays() {
        List<CoffeeDayDto> coffeeDays = coffeeDayService.findAllCoffeeDays();
        return ResponseEntity.status(HttpStatus.OK).body(coffeeDays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeDayDto> findCoffeeDayById(@PathVariable Long id) {
        CoffeeDay coffeeDay = coffeeDayService.findCoffeeDayById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CoffeeDayDto(coffeeDay.getId(), coffeeDay.getCoffeeDate()));
    }
}
