package com.mv.services;

import com.mv.dtos.ItemAssignmentDto;
import com.mv.models.ItemAssignment;
import com.mv.repositories.ItemAssignmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemAssignmentService {

    @Autowired
    private ItemAssignmentRepository itemAssignmentRepository;

    @Transactional
    public ItemAssignmentDto insertItemAssignment(ItemAssignmentDto itemAssignmentDto) {
        for (Long itemId : itemAssignmentDto.getItemId()) {
            if (itemAssignmentRepository.existsItemAssignment(itemAssignmentDto.getUserId(), itemId, itemAssignmentDto.getCoffeeDayId())) {
                throw new RuntimeException("O usuário já possui este item associado a ele!");
            }
            itemAssignmentRepository.insertItemAssignment(itemAssignmentDto.getUserId(), itemId, itemAssignmentDto.getCoffeeDayId());
        }

        ItemAssignment itemAssignment = itemAssignmentRepository.findItemAssignmentByUserIdAndCoffeeDayId(
                itemAssignmentDto.getUserId(), itemAssignmentDto.getCoffeeDayId());

        ItemAssignmentDto resultDto = new ItemAssignmentDto();
        resultDto.setUserId(itemAssignment.getUser().getId());
        resultDto.setCoffeeDayId(itemAssignment.getCoffeeDay().getId());

        return resultDto;
    }

    @Transactional
    public void updateItemAssignment(Long userId, Long itemId, Long coffeDayId, boolean hasBroughtItem) {
        itemAssignmentRepository.updateItemAssignment(userId, itemId, coffeDayId, hasBroughtItem);
    }

    @Transactional
    public void deleteItemAssignment(Long userId, Long itemId, Long coffeDayId) {
        itemAssignmentRepository.deleteItemAssignment(userId, itemId, coffeDayId);
    }
}
