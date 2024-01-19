package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no utilitário de saudação.")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Deve saudar com bom dia.")
    void saudarBomDia() {
        int horaValida = 9;
        String saudacaoBomDia = saudar(horaValida);
        assertEquals("Bom dia", saudacaoBomDia);
    }

    @Test
    void saudarBoaTarde() {
        int horaValida = 14;
        String saudacaoBoaTarde = saudar(horaValida);
        assertEquals("Boa tarde", saudacaoBoaTarde);
    }

    @Test
    void saudarBoaNoite() {
        int horaValida = 19;
        String saudacaoBoaNoite = saudar(horaValida);
        assertEquals("Boa noite", saudacaoBoaNoite);
    }

    @Test
    void deveLancarException() {
        int horaInvalida = -10;
        Executable chamadaInvalidaDeMetodo = () -> saudar(horaInvalida);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, chamadaInvalidaDeMetodo);
        assertEquals("Hora invalida", exception.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        int horaValida = 0;
        Executable chamadaValidaDeMetodo = () -> saudar(horaValida);
        assertDoesNotThrow(chamadaValidaDeMetodo);
    }
}
