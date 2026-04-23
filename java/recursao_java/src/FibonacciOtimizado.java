import java.util.HashMap;
import java.util.Map;

public class FibonacciOtimizado {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        // Casos base
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // Verifica se já foi calculado
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calcula e armazena
        long resultado = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, resultado);

        return resultado;
    }

    public static void main(String[] args) {
        long inicio = System.nanoTime();
        long resultado = fibonacci(40);
        long fim = System.nanoTime();
        System.out.println("Tempo: " + (fim - inicio) / 1_000_000 + "ms");

    }
}
// Complexidade: O(n) tempo, O(n) espaço
