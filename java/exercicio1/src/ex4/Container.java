package ex4;

public interface Container<T> {
    /**
     * Adiciona um item ao container
     */
    void adicionar(T item);

    /**
     * Remove e retorna o último item adicionado (LIFO)
     */
    T remover();

    /**
     * Retorna a quantidade de itens no container
     */
    int tamanho();

    /**
     * Verifica se o container está vazio
     */
    boolean estaVazio();
}
