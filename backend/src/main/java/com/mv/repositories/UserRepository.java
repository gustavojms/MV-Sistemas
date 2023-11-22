package com.mv.repositories;

import com.mv.dtos.UserDto;
import com.mv.models.User;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM TB_USER", nativeQuery = true)
    List<User> findAllUsers();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO TB_USER (NAME, CPF) VALUES(:name, :cpf)", nativeQuery = true)
    void insertUser(@Param("name") String name, @Param("cpf") String cpf);

    @Transactional
    @Query(value = "SELECT * FROM TB_USER WHERE CPF = :cpf", nativeQuery = true)
    User findByCpf(String cpf);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TB_USER SET NAME = :NAME, CPF = :CPF WHERE USER_ID = :userId", nativeQuery = true)
    void updateUser(@Param("userId") Long userId, @Param("NAME") String name, @Param("CPF") String cpf);

    @Modifying
    @Query(value = "DELETE FROM TB_USER WHERE USER_ID = :userId", nativeQuery = true)
    void deleteUser(Long userId);
}
