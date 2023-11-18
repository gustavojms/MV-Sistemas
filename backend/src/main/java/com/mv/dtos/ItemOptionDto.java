package com.mv.dtos;

public class ItemOptionDto {

    private Long id;
    private String item;

    public ItemOptionDto(Long id, String item) {
        this.id = id;
        this.item = item;
    }

    public ItemOptionDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
