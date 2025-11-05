package com.demo.almoxarifado_fifo.repository;

import com.demo.almoxarifado_fifo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
