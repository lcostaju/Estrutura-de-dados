import java.util.List;

public class AppArvoresBinarias {
    public static void main(String[] args) {
        // Arvore da apostila:
        //         10
        //       /    \
        //      5      15
        //     / \    /  \
        //    3   7  12  20
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        No<Integer> n10 = new No<>(10);
        No<Integer> n5 = new No<>(5);
        No<Integer> n15 = new No<>(15);
        No<Integer> n3 = new No<>(3);
        No<Integer> n7 = new No<>(7);
        No<Integer> n12 = new No<>(12);
        No<Integer> n20 = new No<>(20);

        n10.esquerda = n5;
        n10.direita = n15;
        n5.esquerda = n3;
        n5.direita = n7;
        n15.esquerda = n12;
        n15.direita = n20;

        arvore.setRaiz(n10);

        List<Integer> recursivo = arvore.inOrderRecursivo();
        List<Integer> iterativo = arvore.inOrderIterativo();

        System.out.println("In-order recursivo: " + recursivo);
        System.out.println("In-order iterativo: " + iterativo);
        System.out.println("Sao iguais? " + recursivo.equals(iterativo));

        // Esperado para a arvore acima: [3, 5, 7, 10, 12, 15, 20]
    }
}
