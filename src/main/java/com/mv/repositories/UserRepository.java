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

    @Query(value = "SELECT * FROM TB_USER WHERE CPF = :cpf", nativeQuery = true)
    User findByCpf(String cpf);

    @Modifying
    @Query(value = "UPDATE TB_USER SET NAME = :name WHERE id = :userId", nativeQuery = true)
    void updateUserName(Long userId, String name);

    @Modifying
    @Query(value = "DELETE FROM TB_USER WHERE ID = :userId", nativeQuery = true)
    void deleteUser(Long userId);
}
