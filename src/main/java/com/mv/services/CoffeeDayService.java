package com.mv.services;

import com.mv.dtos.CoffeeDayDto;
import com.mv.repositories.CoffeeDayRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeDayService {

    final CoffeeDayRepository coffeDayRepository;

    public CoffeeDayService(CoffeeDayRepository coffeDayRepository) {
        this.coffeDayRepository = coffeDayRepository;
    }

    @Transactional
    public void insertCoffeeDay(CoffeeDayDto coffeeDayDto) {
        LocalDate currentDate = LocalDate.now();

        if (coffeeDayDto.getCoffeeDate().isBefore(currentDate)) {
            throw new RuntimeException("A data do CoffeDay não pode ser anterior a data atual!");
        }

        this.coffeDayRepository.insertCoffeeDate(coffeeDayDto.getCoffeeDate());
    }

    @Transactional
    public void associateUserWithCoffeDay(Long coffeeId, Long userId) {
        this.coffeDayRepository.associateUserToCoffee(coffeeId, userId);
    }

    @Transactional
    public Date findAllCoffeeDays() {
        return this.coffeDayRepository.findAllCoffeeDays();
    }
}
