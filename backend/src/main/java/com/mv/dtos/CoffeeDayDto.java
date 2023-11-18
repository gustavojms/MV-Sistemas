package com.mv.dtos;

import java.time.LocalDate;

public class CoffeeDayDto {

    private Long id;

    private LocalDate coffeeDate;

    public CoffeeDayDto(Long id, LocalDate coffeeDate) {
        this.id = id;
        this.coffeeDate = coffeeDate;
    }

    public CoffeeDayDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCoffeeDate() {
        return coffeeDate;
    }

    public void setCoffeeDate(LocalDate coffeeDate) {
        this.coffeeDate = coffeeDate;
    }
}
