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
@Table(name = "funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false, length = 80)
    private String area;

    @Column(nullable = false)
    private boolean ativo = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime cadastradoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;


    @OneToMany(mappedBy = "funcionario")
    private List<Saida> historicoSaidas;

    @OneToOne
    @JoinColumn(name = "kit_atual_id")
    private KitEmpresa kitAtual;

}
