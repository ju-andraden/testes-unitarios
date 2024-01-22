package com.algaworks.junit.blog.utilidade;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ConversorSlugTest {

    @Test
    void deveConverterJuntoComCodigo() {
        try(MockedStatic<GeradorCodigo> mockedStatic = Mockito.mockStatic(GeradorCodigo.class)) {
            mockedStatic.when(GeradorCodigo::gerar).thenReturn("123456");

            String slug = ConversorSlug.converterJuntoComCodigo("ola mundo");

            assertEquals("ola-mundo-123456", slug);
        }
    }
}