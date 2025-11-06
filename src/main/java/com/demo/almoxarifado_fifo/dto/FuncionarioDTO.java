package com.demo.almoxarifado_fifo.dto;

import lombok.Data;

@Data
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private String area;
    private boolean ativo;
}
