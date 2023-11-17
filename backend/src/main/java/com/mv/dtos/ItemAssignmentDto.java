package com.mv.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ItemAssignmentDto {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long userId;

    @NotNull(message = "O ID do dia de café é obrigatório")
    private Long coffeeDayId;

    private Long itemId;

    private List<Long> itemIds;

    private boolean hasBroughtItem;

    public ItemAssignmentDto(Long userId, Long coffeeDayId, Long itemId, List<Long> itemIds, boolean hasBroughtItem) {
        this.userId = userId;
        this.coffeeDayId = coffeeDayId;
        this.itemId = itemId;
        this.itemIds = itemIds;
        this.hasBroughtItem = hasBroughtItem;
    }

    public ItemAssignmentDto() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCoffeeDayId() {
        return coffeeDayId;
    }

    public void setCoffeeDayId(Long coffeeDayId) {
        this.coffeeDayId = coffeeDayId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public boolean isHasBroughtItem() {
        return hasBroughtItem;
    }

    public void setHasBroughtItem(boolean hasBroughtItem) {
        this.hasBroughtItem = hasBroughtItem;
    }
}
