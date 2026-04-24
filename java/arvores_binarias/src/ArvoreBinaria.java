import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArvoreBinaria<T> {
    private No<T> raiz;

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public List<T> inOrderRecursivo() {
        List<T> resultado = new ArrayList<>();
        inOrderRecursivo(raiz, resultado);
        return resultado;
    }

    private void inOrderRecursivo(No<T> atual, List<T> resultado) {
        if (atual == null) {
            return;
        }
        inOrderRecursivo(atual.esquerda, resultado);
        resultado.add(atual.valor);
        inOrderRecursivo(atual.direita, resultado);
    }

    public List<T> inOrderIterativo() {
        List<T> resultado = new ArrayList<>();
        Stack<No<T>> pilha = new Stack<>();

        No<T> atual = raiz;

        // Sem recursao: desce para a esquerda empilhando o caminho.
        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            resultado.add(atual.valor);
            atual = atual.direita;
        }

        return resultado;
    }

    // Comparacao (apostila):
    // 1) Recursivo: codigo mais curto e legivel; usa pilha de chamadas da JVM.
    // 2) Iterativo: controla a pilha explicitamente (Stack); evita StackOverflow
    //    em arvores muito profundas.
    // 3) Complexidade de tempo: O(n) em ambas, visitando cada no uma vez.
    // 4) Complexidade de espaco: O(h) em ambas, onde h e a altura da arvore.
}
