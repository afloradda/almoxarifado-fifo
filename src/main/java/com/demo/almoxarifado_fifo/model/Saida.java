package com.demo.almoxarifado_fifo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "saidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id",nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "kit_id",nullable = false)
    private KitEmpresa kitEmpresa;

    @Column(nullable = false)
    private LocalDateTime emprestadoEm;
}
