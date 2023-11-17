package com.mv.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mv.dtos.ItemOptionDto;
import com.mv.models.ItemOption;
import com.mv.services.ItemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-option")
public class ItemOptionController {

    @Autowired
    private ItemOptionService itemOptionService;

    @PostMapping("/create")
    public ResponseEntity<String> createItemOption(@RequestBody ItemOptionDto itemOptionDto) {
        itemOptionService.insertItemOption(itemOptionDto.getItem());
        return ResponseEntity.ok("Nova opção de Item criada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<ItemOption>> getAllItemsOptions() {
        return ResponseEntity.ok(itemOptionService.searchAllItemsOptions());
    }

}
