package com.demo.almoxarifado_fifo.controller;

import com.demo.almoxarifado_fifo.dto.FuncionarioDTO;
import com.demo.almoxarifado_fifo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public FuncionarioDTO criar(@RequestBody FuncionarioDTO dto) {
        return funcionarioService.criarFuncionario(dto);
    }

    @PutMapping("/{id}")
    public FuncionarioDTO atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO dto) {
        return funcionarioService.atualizarFuncionario(id, dto);
    }

    @GetMapping("/ativos")
    public List<FuncionarioDTO> listarAtivos(){
        return funcionarioService.listarAtivos();
    }

    @GetMapping("/inativos")
    public List<FuncionarioDTO> listarInativos(){
        return funcionarioService.listarInativos();
    }

    @PutMapping("/{id}/desativar")
    public ResponseEntity<String> desativar(@PathVariable Long id){
        funcionarioService.desativarFuncionario(id);
        return ResponseEntity.ok("Funcionario desativado.");
    }


}
