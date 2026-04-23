package br.edu.iftm.ed;

import br.edu.iftm.ed.desafios.BufferCircular;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BufferCircularTest {

    @Test
    void deveDescartarMaisAntigoQuandoCheio() {
        BufferCircular<String> logs = new BufferCircular<>(3);
        logs.adicionar("INFO 1");
        logs.adicionar("INFO 2");
        logs.adicionar("WARN 3");
        logs.adicionar("ERROR 4");

        assertEquals(3, logs.tamanho());
        assertEquals("INFO 2", logs.removerMaisAntigo());
        assertEquals("WARN 3", logs.removerMaisAntigo());
        assertEquals("ERROR 4", logs.removerMaisAntigo());
        assertTrue(logs.estaVazio());
    }

    @Test
    void removerEmBufferVazio() {
        BufferCircular<Integer> buffer = new BufferCircular<>(2);
        assertThrows(NoSuchElementException.class, buffer::removerMaisAntigo);
    }
}
