package com.grupo19.gastroreserva.unit.domain.entities;

import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HorarioDeFuncionamentoTest {
    @Test
    void deveCriarHorarioDeFuncionamentoComHorariosValidos() {
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(horaAbertura, horaFechamento);

        assertNotNull(horario.getHoraAbertura());
        assertNotNull(horario.getHoraFechamento());
        assertEquals(horaAbertura, horario.getHoraAbertura());
        assertEquals(horaFechamento, horario.getHoraFechamento());
    }
}
