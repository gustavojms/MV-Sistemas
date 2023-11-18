package com.mv.services;

import com.mv.dtos.CoffeeDayDto;
import com.mv.models.CoffeeDay;
import com.mv.repositories.CoffeeDayRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public CoffeeDayDto insertCoffeeDay(CoffeeDayDto coffeeDayDto) {
        LocalDate currentDate = LocalDate.now();

        if (coffeeDayDto.getCoffeeDate().isBefore(currentDate)) {
            throw new RuntimeException("A data do CoffeDay não pode ser anterior a data atual!");
        }

        this.coffeDayRepository.insertCoffeeDate(coffeeDayDto.getCoffeeDate());
        CoffeeDay coffeeDay = this.coffeDayRepository.findByCoffeeDate(coffeeDayDto.getCoffeeDate());
        return new CoffeeDayDto(coffeeDay.getId(), coffeeDay.getCoffeeDate());
    }

    @Transactional
    public List<CoffeeDayDto> findAllCoffeeDays() {
        List<CoffeeDay> coffeeDays = this.coffeDayRepository.findAllCoffeeDays();
        List<CoffeeDayDto> coffeeDaysDto = new ArrayList<>();

        for (CoffeeDay coffeeDay : coffeeDays) {
            CoffeeDayDto coffeeDayDto = new CoffeeDayDto();
            coffeeDayDto.setId(coffeeDay.getId());
            coffeeDayDto.setCoffeeDate(coffeeDay.getCoffeeDate());
            coffeeDaysDto.add(coffeeDayDto);
        }

        return coffeeDaysDto;
    }
}
