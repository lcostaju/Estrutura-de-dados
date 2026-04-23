package br.edu.iftm.ed;

import br.edu.iftm.ed.exercicios.RateLimiterService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RateLimiterServiceTest {

    @Test
    void devePermitirAteLimiteNaJanela() {
        AtomicLong tempo = new AtomicLong(1_000L);
        RateLimiterService service = new RateLimiterService(tempo::get);

        for (int i = 0; i < 10; i++) {
            assertTrue(service.permitir("u1"));
        }

        assertFalse(service.permitir("u1"));
    }

    @Test
    void deveLiberarAposJanelaExpirar() {
        AtomicLong tempo = new AtomicLong(1_000L);
        RateLimiterService service = new RateLimiterService(tempo::get);

        for (int i = 0; i < 10; i++) {
            assertTrue(service.permitir("u2"));
        }
        assertFalse(service.permitir("u2"));

        tempo.addAndGet(60_001L);
        assertTrue(service.permitir("u2"));
    }
}
