package com.mv.services;

import com.mv.dtos.ItemAssignmentDto;
import com.mv.repositories.ItemAssignmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ItemAssignmentService {

    @Autowired
    private ItemAssignmentRepository itemAssignmentRepository;

    @Transactional
    public void insertItemAssignment(ItemAssignmentDto itemAssignmentDto) {
        if (itemAssignmentDto.getItemIds() != null && !itemAssignmentDto.getItemIds().isEmpty()) {
            for (Long itemId : itemAssignmentDto.getItemIds()) {
                if (itemAssignmentRepository.existsItemAssignment(itemAssignmentDto.getUserId(), itemId, itemAssignmentDto.getCoffeeDayId())) {
                    throw new RuntimeException("O usuário já possui este item associado a ele!");
                }
                itemAssignmentRepository.insertItemAssignment(itemAssignmentDto.getUserId(), itemId, itemAssignmentDto.getCoffeeDayId());
            }
        } else {
            if (itemAssignmentRepository.existsItemAssignment(itemAssignmentDto.getUserId(), itemAssignmentDto.getItemId(), itemAssignmentDto.getCoffeeDayId())) {
                throw new RuntimeException("O usuário já possui este item associado a ele!");
            }
            itemAssignmentRepository.insertItemAssignment(itemAssignmentDto.getUserId(), itemAssignmentDto.getItemId(), itemAssignmentDto.getCoffeeDayId());
        }
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
