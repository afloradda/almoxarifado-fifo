package com.demo.almoxarifado_fifo.controller;

import com.demo.almoxarifado_fifo.dto.KitEmpresaDTO;
import com.demo.almoxarifado_fifo.model.KitEmpresa;
import com.demo.almoxarifado_fifo.service.KitEmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kits")
public class KitEmpresaController {

    private final KitEmpresaService kitEmpresaService;

    public KitEmpresaController(KitEmpresaService kitEmpresaService) {
        this.kitEmpresaService = kitEmpresaService;
    }

    @PostMapping
    public KitEmpresa criar(@RequestBody KitEmpresaDTO dto) {
        return kitEmpresaService.criarKitEmpresa(dto);
    }

    @GetMapping
    public List<KitEmpresa> listar() {
        return kitEmpresaService.listarKits();
    }

    @GetMapping("/proximo")
    public KitEmpresa proximoDaFila() {
        return kitEmpresaService.proximDaFila();
    }
}
