package com.mv.repositories;

import com.mv.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "INSERT INTO TB_USER (NAME, CPF) VALUES(:name, :cpf)", nativeQuery = true)
    void insertUser(String name, String cpf);

}
