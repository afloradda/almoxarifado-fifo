package com.demo.almoxarifado_fifo.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {
    public FuncionarioNaoEncontradoException(Long id) {
        super("Funcionário com ID " + id + " não encontrado.");
    }
}
