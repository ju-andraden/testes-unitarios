package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;

import java.math.BigDecimal;

public class EditorTestData {

    private EditorTestData() {
    }

    public static Editor editorNovo() {
        return new Editor(null, "Ju", "ju@email.com", BigDecimal.TEN, true);
    }

    public static Editor editorExistente() {
        return new Editor(1L, "Ju", "ju@email.com", BigDecimal.TEN, true);
    }

    public static Editor editorComIdInexistente() {
        return new Editor(99L, "Ju", "ju@email.com", BigDecimal.TEN, true);
    }
}