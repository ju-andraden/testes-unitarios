package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class CadastroEditorComMockTest {

    @Mock
    ArmazenamentoEditor armazenamentoEditor;
    @Mock
    GerenciadorEnvioEmail gerenciadorEnvioEmail;
    @InjectMocks
    CadastroEditor cadastroEditor;
    Editor editor;

    @BeforeEach
    void init() {
        editor = new Editor(null, "Ju", "ju@email.com", new BigDecimal(10), true);

        Mockito.when(armazenamentoEditor.salvar(Mockito.any(Editor.class)))
                .thenAnswer(invocacao -> {
                   Editor editorPassado = invocacao.getArgument(0, Editor.class);
                   editorPassado.setId(1L);
                   return editorPassado;
                });
    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());
    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_chamar_metodo_salvar_do_armazenamento() {
        cadastroEditor.criar(editor);
        Mockito.verify(armazenamentoEditor, Mockito.times(1))
                .salvar(Mockito.eq(editor));
    }
}
