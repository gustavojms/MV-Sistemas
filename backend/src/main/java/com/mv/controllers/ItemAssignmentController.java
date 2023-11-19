package com.mv.controllers;

import com.mv.dtos.ItemAssignmentDto;
import com.mv.services.ItemAssignmentService;
import com.mv.services.ItemOptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-assignment")
@CrossOrigin(origins = "*")
public class ItemAssignmentController {

    @Autowired
    private ItemAssignmentService itemAssignmentService;

    @PostMapping
    public ResponseEntity<String> insertItemAssignment(@Valid @RequestBody ItemAssignmentDto itemAssignmentDto) {
        itemAssignmentService.insertItemAssignment(itemAssignmentDto);
        return ResponseEntity.ok("Iten(s) associado(s) ao usuário e ao CoffeeDay com sucesso!");
    }

    @PutMapping
    public ResponseEntity<String> updateItemAssignment(
            @RequestBody ItemAssignmentDto itemAssignmentDto) {
        itemAssignmentService.updateItemAssignment(itemAssignmentDto.getUserId(), itemAssignmentDto.getItemId(), itemAssignmentDto.getCoffeeDayId(), itemAssignmentDto.isHasBroughtItem());
        return ResponseEntity.ok("O item foi atualizado e o usuário informado trouxe o item ao CoffeeDay!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItemAssignment(
            @RequestBody ItemAssignmentDto itemAssignmentDto) {
        itemAssignmentService.deleteItemAssignment(itemAssignmentDto.getUserId(), itemAssignmentDto.getItemId(), itemAssignmentDto.getCoffeeDayId());
        return ResponseEntity.ok("O item foi desassociado do CoffeeDay e do usuário com sucesso!");
    }
}
