package com.mv.services;

import com.mv.dtos.ItemOptionDto;
import com.mv.models.ItemOption;
import com.mv.repositories.ItemOptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemOptionService {

    final ItemOptionRepository itemOptionRepository;

    public ItemOptionService(ItemOptionRepository itemOptionRepository) {
        this.itemOptionRepository = itemOptionRepository;
    }

    @Transactional
    public ItemOptionDto insertItemOption(String item) {
        itemOptionRepository.insertItemOption(item);
        ItemOption itemOption = itemOptionRepository.searchItemOption(item);
        return new ItemOptionDto(itemOption.getItemOptionId(), itemOption.getItem());
    }

    @Transactional
    public List<ItemOptionDto> searchAllItemsOptions() {
        List<ItemOption> results = itemOptionRepository.searchAllItemsOptions();
        List<ItemOptionDto> items = new ArrayList<>();
        for (ItemOption itemOption : results) {
            ItemOptionDto itemOptionDto = new ItemOptionDto();
            itemOptionDto.setId(itemOption.getItemOptionId());
            itemOptionDto.setItem(itemOption.getItem());
            items.add(itemOptionDto);
        }
        return items;
    }

    @Transactional
    public ItemOption searchItemOption(String item) {
        return this.itemOptionRepository.searchItemOption(item);
    }

    @Transactional
    public void updateItemOption(Long itemId, String item) {
        this.itemOptionRepository.updateItemOption(itemId, item);
    }

    @Transactional
    public void deleteItemOption(Long itemId) {
        this.itemOptionRepository.deleteItemOption(itemId);
    }
}
