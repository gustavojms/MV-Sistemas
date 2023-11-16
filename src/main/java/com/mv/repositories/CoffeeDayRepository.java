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

    @Modifying
    @Query(value = "INSERT INTO TB_USER_COFFEE (COFFEE_ID, USER_ID) VALUES (:coffeeId, :userId)", nativeQuery = true)
    void associateUserToCoffee(Long coffeeId, Long userId);

    @Modifying
    @Query(value = "SELECT COUNT(*) FROM tb_user_coffee WHERE coffee_id = :coffeeId AND user_id = :userId", nativeQuery = true)
    int countUserBringingItem(Long coffeeId, Long userId);


    @Query(value = "SELECT COFFEE_DATE FROM TB_COFFEE", nativeQuery = true)
    Date findAllCoffeeDays();

}
