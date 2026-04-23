package br.edu.iftm.ed;

import br.edu.iftm.ed.desafios.PilhaComMinimo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilhaComMinimoTest {

    @Test
    void minAposCadaPushEPop() {
        PilhaComMinimo<Integer> pilha = new PilhaComMinimo<>();

        pilha.push(5);
        assertEquals(5, pilha.min());

        pilha.push(3);
        assertEquals(3, pilha.min());

        pilha.push(7);
        assertEquals(3, pilha.min());

        pilha.pop();
        assertEquals(3, pilha.min());

        pilha.pop();
        assertEquals(5, pilha.min());
    }

    @Test
    void removerMinimoDeveAtualizarNovoMinimo() {
        PilhaComMinimo<Integer> pilha = new PilhaComMinimo<>();

        pilha.push(8);
        pilha.push(2);
        pilha.push(4);

        assertEquals(2, pilha.min());
        pilha.pop();
        assertEquals(2, pilha.min());
        pilha.pop();
        assertEquals(8, pilha.min());
    }
}
