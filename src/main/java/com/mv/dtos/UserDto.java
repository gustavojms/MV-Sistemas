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
}
