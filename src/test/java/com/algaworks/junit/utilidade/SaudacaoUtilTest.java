package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
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
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> saudar(-10));
        assertEquals("Hora invalida", illegalArgumentException.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        assertDoesNotThrow(() -> saudar(0));
    }
}
