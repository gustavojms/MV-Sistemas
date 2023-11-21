package com.mv.repositories;

import com.mv.models.ItemOption;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO TB_ITEM_OPTION (ITEM) VALUES (:item)", nativeQuery = true)
    void insertItemOption(@Param("item") String item);

    @Query(value = "SELECT * FROM TB_ITEM_OPTION", nativeQuery = true)
    List<ItemOption> searchAllItemsOptions();

    @Query(value = "SELECT * FROM TB_ITEM_OPTION WHERE ITEM = :item", nativeQuery = true)
    ItemOption searchItemOption(@Param("item") String item);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TB_ITEM_OPTION SET ITEM = :item WHERE ITEM_OPTION_ID = :itemId", nativeQuery = true)
    void updateItemOption(@Param("itemId") Long itemId, @Param("item") String item);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM TB_ITEM_OPTION WHERE ITEM_OPTION_ID = :itemId", nativeQuery = true)
    void deleteItemOption(@Param("itemId") Long itemId);
}
