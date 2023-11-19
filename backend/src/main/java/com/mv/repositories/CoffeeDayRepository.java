package com.mv.repositories;

import com.mv.dtos.CoffeeDayDto;
import com.mv.models.CoffeeDay;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeDayRepository extends JpaRepository<CoffeeDay, Long> {

    @Modifying
    @Query(value = "INSERT INTO TB_COFFEE (COFFEE_DATE) VALUES (:coffeeDate)", nativeQuery = true)
    void insertCoffeeDate(LocalDate coffeeDate);

    @Query(value = "SELECT * FROM TB_COFFEE", nativeQuery = true)
    List<CoffeeDay> findAllCoffeeDays();

    @Query(value = "SELECT * FROM TB_COFFEE WHERE COFFEE_DATE = :coffeeDate", nativeQuery = true)
    CoffeeDay findByCoffeeDate(LocalDate coffeeDate);

    @Query(value = "SELECT * FROM TB_COFFEE WHERE ID = :id", nativeQuery = true)
    CoffeeDay findCoffeeDayById(Long id);

}
