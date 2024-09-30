package com.grupo19.gastroreserva.infra.persistence.horariodefuncionamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HorarioDeFuncionamento")
public class HorarioDeFuncionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horaabertura")
    private LocalTime horaAbertura;

    @Column(name = "horafechamento")
    private LocalTime horaFechamento;

    public HorarioDeFuncionamentoEntity(LocalTime horaAbertura, LocalTime horaFechamento) {
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }
}
