package com.mv.repositories;

import com.mv.models.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {

    @Modifying
    @Query(value = "INSERT INTO TB_ITEM_OPTION (ITEM) VALUES (:item)", nativeQuery = true)
    void insertItemOption(String item);

    @Query(value = "SELECT * FROM TB_ITEM_OPTION", nativeQuery = true)
    List<ItemOption> searchAllItemsOptions();
}
