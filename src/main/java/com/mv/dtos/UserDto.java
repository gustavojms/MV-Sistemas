package com.mv.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public class UserDto {


    private Long id;

    @NotBlank(message = "O nome do colaborador é obrigatório!")
    private String name;

    @CPF(message = "O CPF informado é inválido!")
    @NotBlank(message = "O CPF do colaborador é obrigatório!")
    private String cpf;

    public UserDto(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public UserDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
