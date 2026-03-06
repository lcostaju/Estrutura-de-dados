package ex1;
public class Ex1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Testando Genéricos com Caixa<T> ===\n");

        // Teste 1: Caixa<String>
        System.out.println("1. Testando Caixa<String>:");
        Caixa<String> caixaString = new Caixa<>();
        caixaString.guardar("João Silva");
        System.out.println("   Guardado: 'João Silva'");
        System.out.println("   Recuperado: " + caixaString.recuperar());
        System.out.println();

        // Teste 2: Caixa<Integer>
        System.out.println("2. Testando Caixa<Integer>:");
        Caixa<Integer> caixaInteger = new Caixa<>();
        caixaInteger.guardar(42);
        System.out.println("   Guardado: 42");
        System.out.println("   Recuperado: " + caixaInteger.recuperar());
        System.out.println();

        // Teste 3: Caixa<Double>
        System.out.println("3. Testando Caixa<Double>:");
        Caixa<Double> caixaDouble = new Caixa<>();
        caixaDouble.guardar(3.14159);
        System.out.println("   Guardado: 3.14159");
        System.out.println("   Recuperado: " + caixaDouble.recuperar());
        System.out.println();

        // Teste 4: O que acontece ao tentar guardar Integer em Caixa<String>?
        System.out.println("4. Tentando guardar Integer em Caixa<String>:");
        System.out.println("   ERRO DE COMPILAÇÃO!");
        System.out.println("   O compilador não permite isso em tempo de compilação.");
        System.out.println("   Genéricos fornecem segurança de tipo!");
        
        // Descomente a linha abaixo para ver o erro do compilador:
        // caixaString.guardar(123);  // ← Erro: incompatible types
    }
}
