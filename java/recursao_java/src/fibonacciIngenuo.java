public class fibonacciIngenuo {
    public static int fibonacciIngenuo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacciIngenuo(n - 1) + fibonacciIngenuo(n - 2);
    }

    // Complexidade: O(2^n) - EXPONENCIAL!
    public static void main(String[] args) {
        long inicio = System.nanoTime();
        long resultado = fibonacciIngenuo(40);
        long fim = System.nanoTime();
        System.out.println("Tempo: " + (fim - inicio) / 1_000_000 + "ms");

    }
}
