package br.edu.iftm.ed;

import br.edu.iftm.ed.estrutura.FilaDuasPilhas;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilaDuasPilhasTest {

    @Test
    void dequeueDeveRespeitarFifo() {
        FilaDuasPilhas<Integer> fila = new FilaDuasPilhas<>();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        assertEquals(1, fila.dequeue());
        assertEquals(2, fila.dequeue());
        assertEquals(3, fila.dequeue());
        assertTrue(fila.isEmpty());
    }

    @Test
    void dequeueEmFilaVazia() {
        FilaDuasPilhas<Integer> fila = new FilaDuasPilhas<>();
        assertThrows(NoSuchElementException.class, fila::dequeue);
    }
}
