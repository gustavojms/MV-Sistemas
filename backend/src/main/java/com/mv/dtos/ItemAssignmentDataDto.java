package com.mv.dtos;

public class ItemAssignmentDataDto extends ItemAssignmentDto {

    private String username;
    private String cpf;
    private String item;

    public ItemAssignmentDataDto(String username, String cpf, String item) {
        this.username = username;
        this.cpf = cpf;
        this.item = item;
    }

    public ItemAssignmentDataDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
