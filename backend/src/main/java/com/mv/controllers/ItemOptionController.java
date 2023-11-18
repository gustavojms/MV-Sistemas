package com.mv.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mv.dtos.ItemOptionDto;
import com.mv.models.ItemOption;
import com.mv.services.ItemOptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-option")
public class ItemOptionController {

    @Autowired
    private ItemOptionService itemOptionService;

    @PostMapping
    public ResponseEntity<ItemOptionDto> createItemOption(@Valid @RequestBody ItemOptionDto itemOptionDto) {
        ItemOptionDto item = itemOptionService.insertItemOption(itemOptionDto.getItem());
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping
    public ResponseEntity<List<ItemOption>> getAllItemsOptions() {
        return ResponseEntity.ok(itemOptionService.searchAllItemsOptions());
    }

    @GetMapping("/{item}")
    public ResponseEntity<ItemOption> getItemOption(@PathVariable String item) {
        return ResponseEntity.status(HttpStatus.FOUND).body(itemOptionService.searchItemOption(item));
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemOptionDto> updateItemOption(@PathVariable Long itemId, @RequestBody ItemOptionDto itemOptionDto) {
        itemOptionService.updateItemOption(itemId, itemOptionDto.getItem());
        return ResponseEntity.status(HttpStatus.OK).body(itemOptionDto);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItemOption(@PathVariable Long itemId) {
        itemOptionService.deleteItemOption(itemId);
        return ResponseEntity.status(HttpStatus.OK).body("Item deletado com sucesso!");
    }

}
