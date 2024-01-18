package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    @Test
    void saque() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("70.00"));
        contaBancaria.saque(new BigDecimal("50.01"));
        assertEquals(new BigDecimal("19.99"), contaBancaria.saldo());
    }

    @Test
    void saqueValorZeradoFalha() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class, ()-> contaBancaria.saque(new BigDecimal("0.00")));
    }

    @Test
    void saqueValorNegativoFalha() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class, ()-> contaBancaria.saque(new BigDecimal("-10.00")));
    }

    @Test
    void saqueValorMaiorFalha() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(RuntimeException.class, ()-> contaBancaria.saque(new BigDecimal("20.00")));
    }

    @Test
    void saqueValorIgualOk() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("10.00"));
        contaBancaria.saque(new BigDecimal("10.00"));
        assertEquals(new BigDecimal("0.00"), contaBancaria.saldo());
    }

    @Test
    void saqueValorNullFalha() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class, ()-> conta.saque(null));
    }

    @Test
    void deposito() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("10.00"));
        conta.deposito(new BigDecimal("10.00"));
        assertEquals(new BigDecimal("20.00"), conta.saldo());
    }

    @Test
    void depositoValorZeradoFalha() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class, ()-> conta.deposito(new BigDecimal("0.00")));
    }

    @Test
    void depositoValorNegativoFalha() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class, ()-> conta.deposito(new BigDecimal("-10.0")));
    }

    @Test
    void depositoValorNullFalha() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class, ()-> conta.deposito(null));
    }

    @Test
    void saqueAposDeposito() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("10.00"));
        conta.deposito(new BigDecimal("10.00"));
        conta.saque(new BigDecimal("5.00"));
        assertEquals(new BigDecimal("15.00"), conta.saldo());
    }

    @Test
    void saldo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("29.90"));
        assertEquals(new BigDecimal("29.90"), conta.saldo());
    }

    @Test
    void criarContaComSaldoNullFalha() {
        assertThrows(IllegalArgumentException.class, ()-> new ContaBancaria(null));
    }
}
