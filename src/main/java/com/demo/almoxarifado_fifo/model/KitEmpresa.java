package com.demo.almoxarifado_fifo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "kits_empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KitEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String codigo;

    @Column(nullable = false)
    private boolean disponivel = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime cadastradoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;


    @OneToMany(mappedBy = "kitEmpresa")
    private List<Saida> historicoSaidas;

    @OneToOne
    @JoinColumn(name = "emprestado_para_id")
    private Funcionario funcionarioAtual;
}
