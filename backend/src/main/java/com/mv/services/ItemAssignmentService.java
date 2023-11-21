package com.mv.services;

import com.mv.dtos.ItemAssignmentDataDto;
import com.mv.dtos.ItemAssignmentDto;
import com.mv.dtos.ItemOptionDto;
import com.mv.models.ItemAssignment;
import com.mv.models.ItemOption;
import com.mv.models.User;
import com.mv.repositories.ItemAssignmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemAssignmentService {

    @Autowired
    private ItemAssignmentRepository itemAssignmentRepository;

    @Transactional
    public ItemAssignmentDto insertItemAssignment(ItemAssignmentDto itemAssignmentDto) {
        for (Long itemId : itemAssignmentDto.getItemId()) {
            if (itemAssignmentRepository.existsItemAssignment(itemAssignmentDto.getUserId(), itemId, itemAssignmentDto.getCoffeeDayId())) {
                throw new RuntimeException("O usuário já possui este item associado a ele!");
            } else if (itemAssignmentRepository.existsItemAssignmentByCoffeeDayIdAndItemId(itemId, itemAssignmentDto.getCoffeeDayId())) {
                throw new RuntimeException("O item já está associado a outro usuário!");
            }
            itemAssignmentRepository.insertItemAssignment(itemAssignmentDto.getUserId(), itemId, itemAssignmentDto.getCoffeeDayId());
        }

        ItemAssignmentDto resultDto = new ItemAssignmentDto();
        resultDto.setUserId(itemAssignmentDto.getUserId());
        resultDto.setCoffeeDayId(itemAssignmentDto.getCoffeeDayId());

        List<Long> itemIds = itemAssignmentDto.getItemId().stream().distinct().toList();
        resultDto.setItemId(itemIds);

        return resultDto;
    }

    @Transactional
    public ItemAssignmentDto updateItemAssignment(Long userId, Long coffeeDayId, boolean hasBroughtItem) {
        itemAssignmentRepository.updateItemAssignment(userId, coffeeDayId, hasBroughtItem);
        List<ItemAssignment> itemAssignment = itemAssignmentRepository.findItemAssignmentByUserIdAndCoffeeDayId(userId, coffeeDayId);
        return new ItemAssignmentDto(itemAssignment.get(0).getUser().getUserId(), itemAssignment.get(0).getCoffeeDay().getCoffeeDayId(), Collections.singletonList(itemAssignment.get(0).getItemOption().getItemOptionId()), itemAssignment.get(0).isHasBroughtItem());
    }

    @Transactional
    public void deleteItemAssignment(Long userId, Long itemId, Long coffeDayId) {
        itemAssignmentRepository.deleteItemAssignment(userId, itemId, coffeDayId);
    }

    @Transactional
    public List<ItemAssignmentDataDto> findUsersByCoffeeId(Long coffeeDayId) {
        List<Object[]> itemAssignment = itemAssignmentRepository.findUsersByCoffeeId(coffeeDayId);
        List<ItemAssignmentDataDto> assignmentDto = new ArrayList<>();

        for (Object[] objects : itemAssignment) {
            ItemAssignmentDataDto itemAssignmentDataDto = new ItemAssignmentDataDto();
            itemAssignmentDataDto.setUserId(Long.parseLong(objects[0].toString()));
            itemAssignmentDataDto.setCpf(objects[1].toString());
            itemAssignmentDataDto.setUsername(objects[2].toString());
            itemAssignmentDataDto.setHasBroughtItem(objects[3].toString().equals("1"));
            assignmentDto.add(itemAssignmentDataDto);
        }

        return assignmentDto;
    }

    @Transactional
    public List<ItemOptionDto> findAllCoffeeDayDetailsByUserId(Long coffeeDayId) {
        List<Object[]> itemAssignment = itemAssignmentRepository.findItemsByCoffeeDayId(coffeeDayId);
        List<ItemOptionDto> itemOptionDto = new ArrayList<>();

        for (Object[] objects : itemAssignment) {
            ItemOptionDto itemOption = new ItemOptionDto();
            itemOption.setId(Long.parseLong(objects[1].toString()));
            itemOption.setItem(objects[0].toString());
            itemOptionDto.add(itemOption);
        }

        return itemOptionDto;
    }

}
