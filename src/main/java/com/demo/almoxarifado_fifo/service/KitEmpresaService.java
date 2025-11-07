package com.demo.almoxarifado_fifo.service;

import com.demo.almoxarifado_fifo.dto.KitEmpresaDTO;
import com.demo.almoxarifado_fifo.model.KitEmpresa;
import com.demo.almoxarifado_fifo.repository.KitEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class KitEmpresaService {
    private final KitEmpresaRepository kitEmpresaRepository;

    private final Queue<KitEmpresa> fila = new LinkedList<>();

    public KitEmpresaService(KitEmpresaRepository kitEmpresaRepository) {
        this.kitEmpresaRepository = kitEmpresaRepository;
    }

    public KitEmpresa criarKitEmpresa(KitEmpresaDTO dto){
        KitEmpresa kitEmpresa = new KitEmpresa();
        kitEmpresa.setCodigo(dto.getCodigo());
        kitEmpresa.setDisponivel(true);

        kitEmpresaRepository.save(kitEmpresa);

        fila.add(kitEmpresa);

        return kitEmpresa;
    }

    public List<KitEmpresa> listarKits(){
        return kitEmpresaRepository.findAll();
    }

    public KitEmpresa proximDaFila(){
        if(fila.isEmpty()){
            throw new RuntimeException("Nenhum KitEmpresa foi encontrado."); // Criar exceção customizada
        }

        return fila.peek();
    }

    public KitEmpresa emprestarProximoKit(){
        KitEmpresa kit = fila.poll();

        if(kit == null){
            throw new RuntimeException("Nenhum kit disponível para emprestar.");
        }
        kit.setDisponivel(false);
        kitEmpresaRepository.save(kit);

        return kit;
    }

    public void devolverKit(Long id){
        KitEmpresa kit = kitEmpresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kit não encontrado."));

        kit.setDisponivel(true);
        kitEmpresaRepository.save(kit);

        fila.add(kit);
    }


}
