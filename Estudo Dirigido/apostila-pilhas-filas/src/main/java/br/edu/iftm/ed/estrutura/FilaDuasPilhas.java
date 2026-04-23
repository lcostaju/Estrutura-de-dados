package br.edu.iftm.ed.estrutura;

import java.util.NoSuchElementException;

public class FilaDuasPilhas<T> implements Fila<T> {
    private final PilhaArray<T> entrada = new PilhaArray<>();
    private final PilhaArray<T> saida = new PilhaArray<>();

    @Override
    public void enqueue(T elemento) {
        entrada.push(elemento);
    }

    @Override
    public T dequeue() {
        transferirSeNecessario();
        if (saida.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        return saida.pop();
    }

    @Override
    public T peek() {
        transferirSeNecessario();
        if (saida.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        return saida.peek();
    }

    @Override
    public boolean isEmpty() {
        return entrada.isEmpty() && saida.isEmpty();
    }

    @Override
    public int size() {
        return entrada.size() + saida.size();
    }

    private void transferirSeNecessario() {
        if (saida.isEmpty()) {
            while (!entrada.isEmpty()) {
                saida.push(entrada.pop());
            }
        }
    }

    // Resposta pedida no exercicio:
    // dequeue() no pior caso e O(n) quando precisa transferir todos os elementos.
    // No custo amortizado, cada elemento e movido no maximo 1 vez entre pilhas,
    // entao dequeue() fica O(1) amortizado em uma sequencia de operacoes.
    // Esse modelo pode ficar ineficiente em lotes alternando picos de enqueue
    // seguidos de dequeue que forcam transferencias grandes de uma vez.
}
