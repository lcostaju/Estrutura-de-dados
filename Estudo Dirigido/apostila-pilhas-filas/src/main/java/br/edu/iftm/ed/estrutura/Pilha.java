package br.edu.iftm.ed.estrutura;

public interface Pilha<T> {
    void push(T elemento);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
}
