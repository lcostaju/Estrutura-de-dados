package br.edu.iftm.ed;

import br.edu.iftm.ed.exercicios.ExerciciosCap8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExerciciosCap8Test {

    @Test
    void inverterCasoNormal() {
        assertEquals("MTFI", ExerciciosCap8.inverter("IFTM"));
    }

    @Test
    void inverterCasoBordaTextoVazio() {
        assertEquals("", ExerciciosCap8.inverter(""));
    }

    @Test
    void avaliarPosFixaCasoNormal() {
        assertEquals(14.0, ExerciciosCap8.avaliarPosFixa("5 1 2 + 4 * + 3 -"));
    }

    @Test
    void avaliarPosFixaComModulo() {
        assertEquals(2.0, ExerciciosCap8.avaliarPosFixa("20 6 %"));
    }

    @Test
    void avaliarPosFixaDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> ExerciciosCap8.avaliarPosFixa("5 0 /"));
    }

    @Test
    void avaliarPosFixaExpressaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> ExerciciosCap8.avaliarPosFixa("5 +"));
    }
}
