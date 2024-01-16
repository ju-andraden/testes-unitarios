package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {

    @Test
    void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Ju", "Andrade");

        assertAll("Asserções de pessoa",
                () -> assertEquals("Ju", pessoa.getNome()),
                () -> assertEquals("Andrade", pessoa.getSobrenome()));
    }
}
