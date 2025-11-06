package com.demo.almoxarifado_fifo.service;

import com.demo.almoxarifado_fifo.dto.FuncionarioDTO;
import com.demo.almoxarifado_fifo.exception.FuncionarioNaoEncontradoException;
import com.demo.almoxarifado_fifo.model.Funcionario;
import com.demo.almoxarifado_fifo.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public FuncionarioDTO criarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setArea(dto.getArea());
        funcionario.setAtivo(dto.isAtivo());

        Funcionario salvo = funcionarioRepository.save(funcionario);
        dto.setId(salvo.getId());
        return dto;
    }

    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(id));

        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setArea(dto.getArea());
        funcionario.setAtivo(dto.isAtivo());

        Funcionario atualizado = funcionarioRepository.save(funcionario);
        return toDTO(atualizado);
    }

    public List<FuncionarioDTO> listarAtivos() {
        return funcionarioRepository.findByAtivoTrue()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<FuncionarioDTO> listarInativos() {
        return funcionarioRepository.findByAtivoFalse()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void desativarFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(id));

        funcionario.setAtivo(false);
        funcionarioRepository.save(funcionario);
    }

    private FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setEmail(funcionario.getEmail());
        dto.setEndereco(funcionario.getEndereco());
        dto.setArea(funcionario.getArea());
        dto.setAtivo(funcionario.isAtivo());

        return dto;
    }
}
