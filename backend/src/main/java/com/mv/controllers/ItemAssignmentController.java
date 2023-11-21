package com.mv.controllers;

import com.mv.dtos.ItemAssignmentDataDto;
import com.mv.dtos.ItemAssignmentDto;
import com.mv.dtos.ItemOptionDto;
import com.mv.models.ItemAssignment;
import com.mv.services.ItemAssignmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/item-assignment")
@CrossOrigin(origins = "*")
public class ItemAssignmentController {

    @Autowired
    private ItemAssignmentService itemAssignmentService;

    @PostMapping
    public ResponseEntity<ItemAssignmentDto> insertItemAssignment(@Valid @RequestBody ItemAssignmentDto itemAssignmentDto) {
        ItemAssignmentDto itemAssignment = itemAssignmentService.insertItemAssignment(itemAssignmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemAssignment);
    }

    @PutMapping
    public ResponseEntity<ItemAssignmentDto> updateItemAssignment(
            @RequestBody ItemAssignmentDto itemAssignmentDto) {
        ItemAssignmentDto itemAssignment = itemAssignmentService.updateItemAssignment(itemAssignmentDto.getUserId(), itemAssignmentDto.getCoffeeDayId(), itemAssignmentDto.isHasBroughtItem());
        return ResponseEntity.status(HttpStatus.OK).body(itemAssignment);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItemAssignment(
            @RequestBody ItemAssignmentDto itemAssignmentDto) {
        itemAssignmentService.deleteItemAssignment(itemAssignmentDto.getUserId(), itemAssignmentDto.getItemId().get(0), itemAssignmentDto.getCoffeeDayId());
        return ResponseEntity.ok("O item foi desassociado do CoffeeDay e do usuário com sucesso!");
    }

    @GetMapping("/{coffeeDayId}")
    public ResponseEntity<List<ItemAssignmentDataDto>> findAllItemAssignments(@PathVariable Long coffeeDayId) {
        return ResponseEntity.status(HttpStatus.OK).body(itemAssignmentService.findUsersByCoffeeId(coffeeDayId));
    }

    @GetMapping("/items/{coffeeDayId}")
    public ResponseEntity<List<ItemOptionDto>> findAllItemAssignmentsByUserId(@PathVariable Long coffeeDayId) {
        return ResponseEntity.status(HttpStatus.OK).body(itemAssignmentService.findAllCoffeeDayDetailsByUserId(coffeeDayId));
    }
}
