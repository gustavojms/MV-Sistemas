package com.mv.repositories;

import com.mv.models.ItemAssignment;
import com.mv.models.ItemOption;
import com.mv.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemAssignmentRepository extends JpaRepository<ItemAssignment, Long>{

    @Modifying
    @Query(value = "INSERT INTO TB_ITEM_ASSIGNMENT (id_user, item_id, coffee_day_id) " +
            "VALUES (:userId, :itemId, :coffeeDayId)", nativeQuery = true)
    void insertItemAssignment(@Param("userId") Long userId, @Param("itemId") Long itemId, @Param("coffeeDayId") Long coffeeDayId);

    @Modifying
    @Query(value = "UPDATE TB_ITEM_ASSIGNMENT SET has_brought_item = :hasBroughtItem " +
            "WHERE id_user = :userId AND coffee_day_id = :coffeeDayId", nativeQuery = true)
    void updateItemAssignment(@Param("userId") Long userId, @Param("coffeeDayId") Long coffeeDayId, @Param("hasBroughtItem") boolean hasBroughtItem);

    @Modifying
    @Query(value = "DELETE FROM TB_ITEM_ASSIGNMENT WHERE user_id = :userId AND item_id = :itemId AND coffee_day_id = :coffeeDayId", nativeQuery = true)
    void deleteItemAssignment(@Param("userId") Long userId, @Param("itemId") Long itemId, @Param("coffeeDayId") Long coffeeDayId);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 'TRUE' ELSE 'FALSE' END FROM TB_ITEM_ASSIGNMENT WHERE ID_USER = :userId AND ITEM_ID = :itemId AND COFFEE_DAY_ID = :coffeeDayId", nativeQuery = true)
    boolean existsItemAssignment(@Param("userId") Long userId, @Param("itemId") Long itemId, @Param("coffeeDayId") Long coffeeDayId);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 'TRUE' ELSE 'FALSE' END FROM TB_ITEM_ASSIGNMENT WHERE COFFEE_DAY_ID = :coffeeDayId AND ITEM_ID = :itemId", nativeQuery = true)
    boolean existsItemAssignmentByCoffeeDayIdAndItemId(@Param("itemId") Long itemId, @Param("coffeeDayId") Long coffeeDayId);

    @Query(value = "SELECT i.item, ia.id_user FROM TB_ITEM_OPTION i INNER JOIN TB_ITEM_ASSIGNMENT ia ON ia.item_id = i.item_option_id INNER JOIN TB_USER u ON u.user_id = ia.id_user WHERE ia.coffee_day_id = :coffeeDayId", nativeQuery = true)
    List<Object[]> findItemsByCoffeeDayId(@Param("coffeeDayId") Long coffeeDayId);

    @Query(value = "SELECT u.user_id, u.cpf, u.name, ia.has_brought_item FROM TB_USER u INNER JOIN TB_ITEM_ASSIGNMENT IA ON ia.id_user = u.user_id INNER JOIN TB_ITEM_OPTION i ON i.item_option_id = ia.item_id WHERE ia.coffee_day_id = :coffeeDayId GROUP BY u.user_id, u.cpf, u.name, ia.has_brought_item", nativeQuery = true)
    List<Object[]> findUsersByCoffeeId(@Param("coffeeDayId") Long coffeeDayId);

}
