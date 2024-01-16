package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class SimuladorEsperaTest {

    @Test
    //desabilita o teste
    @Disabled("Não é mais aplicável.")
    void deveEsperarENaoDarTimeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}
