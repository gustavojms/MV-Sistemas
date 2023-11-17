package com.mv.services;

import com.mv.models.ItemOption;
import com.mv.repositories.ItemOptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemOptionService {

    final ItemOptionRepository itemOptionRepository;

    public ItemOptionService(ItemOptionRepository itemOptionRepository) {
        this.itemOptionRepository = itemOptionRepository;
    }

    @Transactional
    public void insertItemOption(String item) {
        itemOptionRepository.insertItemOption(item);
    }

    @Transactional
    public List<ItemOption> searchAllItemsOptions() {
        return this.itemOptionRepository.searchAllItemsOptions();
    }
}
