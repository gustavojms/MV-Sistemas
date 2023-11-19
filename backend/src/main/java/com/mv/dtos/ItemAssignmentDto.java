package com.mv.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ItemAssignmentDto {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long userId;

    @NotNull(message = "O ID do dia de café é obrigatório")
    private Long coffeeDayId;

    private List<Long> itemId;


    private boolean hasBroughtItem;

    public ItemAssignmentDto(Long userId, Long coffeeDayId, List<Long> itemId, boolean hasBroughtItem) {
        this.userId = userId;
        this.coffeeDayId = coffeeDayId;
        this.itemId = itemId;
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

    public List<Long> getItemId() {
        return itemId;
    }

    public void setItemId(List<Long> itemId) {
        this.itemId = itemId;
    }

    public boolean isHasBroughtItem() {
        return hasBroughtItem;
    }

    public void setHasBroughtItem(boolean hasBroughtItem) {
        this.hasBroughtItem = hasBroughtItem;
    }
}
