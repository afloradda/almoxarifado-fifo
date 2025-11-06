package com.demo.almoxarifado_fifo.service;

import com.demo.almoxarifado_fifo.dto.FuncionarioDTO;
import com.demo.almoxarifado_fifo.exception.FuncionarioNaoEncontradoException;
import com.demo.almoxarifado_fifo.model.Funcionario;
import com.demo.almoxarifado_fifo.repository.FuncionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoEncontradoAoAtualizarStatus() {
        when(funcionarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> funcionarioService.desativarFuncionario(99L))
                .isInstanceOf(FuncionarioNaoEncontradoException.class)
                .hasMessage("Funcionário não encontrado.");

        verify(funcionarioRepository, never()).save(any(Funcionario.class));
    }

}
