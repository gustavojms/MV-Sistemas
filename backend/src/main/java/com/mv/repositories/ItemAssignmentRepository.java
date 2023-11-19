package com.mv.repositories;

import com.mv.models.ItemAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAssignmentRepository extends JpaRepository<ItemAssignment, Long>{

    @Modifying
    @Query(value = "INSERT INTO TB_ITEM_ASSIGNMENT (user_id, item_id, coffee_day_id) " +
            "VALUES (:userId, :itemId, :coffeeDayId)", nativeQuery = true)
    void insertItemAssignment(Long userId, Long itemId, Long coffeeDayId);

    @Modifying
    @Query(value = "UPDATE TB_ITEM_ASSIGNMENT SET has_brought_item = :hasBroughtItem " +
            "WHERE user_id = :userId AND item_id = :itemId AND coffee_day_id = :coffeeDayId", nativeQuery = true)
    void updateItemAssignment(Long userId, Long itemId, Long coffeeDayId, boolean hasBroughtItem);

    @Modifying
    @Query(value = "DELETE FROM TB_ITEM_ASSIGNMENT WHERE user_id = :userId AND item_id = :itemId AND coffee_day_id = :coffeeDayId", nativeQuery = true)
    void deleteItemAssignment(Long userId, Long itemId, Long coffeeDayId);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 'TRUE' ELSE 'FALSE' END FROM TB_ITEM_ASSIGNMENT WHERE USER_ID = :userId AND ITEM_ID = :itemId AND COFFEE_DAY_ID = :coffeeDayId", nativeQuery = true)
    boolean existsItemAssignment(Long userId, Long itemId, Long coffeeDayId);

    @Query(value = "SELECT * FROM TB_ITEM_ASSIGNMENT WHERE USER_ID = :userId AND COFFEE_DAY_ID = :coffeeDayId", nativeQuery = true)
    ItemAssignment findItemAssignmentByUserIdAndCoffeeDayId(Long userId, Long coffeeDayId);

}
