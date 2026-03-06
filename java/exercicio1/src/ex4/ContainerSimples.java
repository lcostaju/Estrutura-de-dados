package ex4;

public class ContainerSimples<T> implements Container<T> {
    private Object[] items;
    private int tamanhoAtual;
    private static final int CAPACIDADE_INICIAL = 10;

    // Construtor
    public ContainerSimples() {
        this.items = new Object[CAPACIDADE_INICIAL];
        this.tamanhoAtual = 0;
    }

    @Override
    public void adicionar(T item) {
        // Se atingiu a capacidade, cresce o array
        if (tamanhoAtual == items.length) {
            redimensionar();
        }
        items[tamanhoAtual] = item;
        tamanhoAtual++;
    }

    @Override
    public T remover() {
        if (estaVazio()) {
            throw new IllegalStateException("Container vazio! Não há item a remover.");
        }
        tamanhoAtual--;
        @SuppressWarnings("unchecked")
        T item = (T) items[tamanhoAtual];
        items[tamanhoAtual] = null; // Limpa a referência
        return item;
    }

    @Override
    public int tamanho() {
        return tamanhoAtual;
    }

    @Override
    public boolean estaVazio() {
        return tamanhoAtual == 0;
    }

    /**
     * Redimensiona o array, dobrando sua capacidade
     */
    private void redimensionar() {
        Object[] novoArray = new Object[items.length * 2];
        System.arraycopy(items, 0, novoArray, 0, items.length);
        items = novoArray;
    }

    /**
     * Retorna a capacidade atual da array interna
     */
    public int capacidade() {
        return items.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanhoAtual; i++) {
            sb.append(items[i]);
            if (i < tamanhoAtual - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
