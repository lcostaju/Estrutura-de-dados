package br.edu.iftm.ed.exercicios;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongSupplier;

public class RateLimiterService {
    private static final int MAX_REQS = 10;
    private static final long JANELA_MS = 60_000L;

    private final Map<String, Deque<Long>> historico = new ConcurrentHashMap<>();
    private final LongSupplier relogio;

    public RateLimiterService() {
        this(System::currentTimeMillis);
    }

    public RateLimiterService(LongSupplier relogio) {
        this.relogio = relogio;
    }

    public boolean permitir(String userId) {
        long agora = relogio.getAsLong();
        Deque<Long> fila = historico.computeIfAbsent(userId, k -> new ArrayDeque<>());

        synchronized (fila) {
            // (a) peekFirst() vem antes de pollFirst() para checar a condicao
            // e remover somente quando o timestamp ja saiu da janela.
            while (!fila.isEmpty() && agora - fila.peekFirst() > JANELA_MS) {
                fila.pollFirst();
            }

            if (fila.size() < MAX_REQS) {
                fila.addLast(agora);
                return true;
            }
            return false;
        }
    }

    public int tamanhoHistoricoUsuario(String userId) {
        Deque<Long> fila = historico.get(userId);
        return fila == null ? 0 : fila.size();
    }

    public int totalUsuariosNoMapa() {
        return historico.size();
    }

    // (b) ConcurrentHashMap e usado em vez de HashMap para acesso concorrente
    // seguro em cenarios com multiplas threads.
    // (c) Usuarios inativos permanecem no mapa sem limpeza explicita; portanto,
    // o mapa pode crescer indefinidamente se nao houver estrategia de expiracao.
}
