package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9, 10, 11})
    public void Dado_horario_matinal_Entao_deve_retornar_bom_dia(int hora) {
        String saudacaoBomDia = saudar(hora);
        assertThat(saudacaoBomDia).isEqualTo("Bom dia");
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 13, 14, 15, 16, 17})
    public void Dado_horario_matinal_Entao_deve_retornar_boa_tarde(int hora) {
        String saudacaoBoaTarde = saudar(hora);
        assertEquals("Boa tarde", saudacaoBoaTarde);
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 19, 20, 21, 22, 23})
    public void Dado_horario_noturno_Entao_deve_retornar_boa_noite(int hora) {
        String saudacaoBoaNoite = saudar(hora);
        assertEquals("Boa noite", saudacaoBoaNoite);
    }

    @Test
    void deveLancarException() {
        int horaInvalida = -10;
        assertThatThrownBy(() -> saudar(horaInvalida))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hora invalida");
    }

    @Test
    void naoDeveLancarException() {
        int horaValida = 0;
        Executable chamadaValidaDeMetodo = () -> saudar(horaValida);
        assertDoesNotThrow(chamadaValidaDeMetodo);
    }
}
