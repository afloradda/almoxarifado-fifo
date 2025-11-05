package com.demo.almoxarifado_fifo.repository;

import com.demo.almoxarifado_fifo.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long> {
}
