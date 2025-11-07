package com.demo.almoxarifado_fifo.repository;

import com.demo.almoxarifado_fifo.model.KitEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KitEmpresaRepository extends JpaRepository<KitEmpresa, Long> {
    List<KitEmpresa> findByDisponivelTrue();
    List<KitEmpresa> findByDisponivelFalse();
    List<KitEmpresa> findByCodigo(String codigo);
}
