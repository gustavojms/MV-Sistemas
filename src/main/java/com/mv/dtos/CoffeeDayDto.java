package com.mv.dtos;

import java.time.LocalDate;

public class CoffeeDayDto {

    private LocalDate coffeeDate;

    public CoffeeDayDto(LocalDate coffeeDate) {
        this.coffeeDate = coffeeDate;
    }

    public CoffeeDayDto() {}

    public LocalDate getCoffeeDate() {
        return coffeeDate;
    }

    public void setCoffeeDate(LocalDate coffeeDate) {
        this.coffeeDate = coffeeDate;
    }
}
