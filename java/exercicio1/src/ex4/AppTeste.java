package ex4;

public class AppTeste {
    public static void main(String[] args) {
        System.out.println("=== Testando Container<T> ===\n");

        // Teste 1: ContainerSimples<String>
        System.out.println("1. ContainerSimples<String> - Pilha de Strings:");
        ContainerSimples<String> containerString = new ContainerSimples<>();
        
        System.out.println("   Está vazio? " + containerString.estaVazio());
        System.out.println("   Tamanho: " + containerString.tamanho());
        
        containerString.adicionar("Java");
        containerString.adicionar("Python");
        containerString.adicionar("JavaScript");
        System.out.println("   Após adicionar 3 linguagens: " + containerString);
        System.out.println("   Tamanho: " + containerString.tamanho() + " | Capacidade: " + containerString.capacidade());
        
        String removido = containerString.remover();
        System.out.println("   Removido: " + removido);
        System.out.println("   Container agora: " + containerString);
        System.out.println();

        // Teste 2: ContainerSimples<Integer>
        System.out.println("2. ContainerSimples<Integer> - Pilha de Números:");
        ContainerSimples<Integer> containerInt = new ContainerSimples<>();
        
        for (int i = 1; i <= 5; i++) {
            containerInt.adicionar(i * 10);
        }
        System.out.println("   Após adicionar 5 números: " + containerInt);
        System.out.println("   Tamanho: " + containerInt.tamanho() + " | Capacidade: " + containerInt.capacidade());
        
        System.out.println("   Removendo elementos:");
        while (!containerInt.estaVazio()) {
            System.out.println("   └─ Removido: " + containerInt.remover());
        }
        System.out.println("   Container vazio? " + containerInt.estaVazio());
        System.out.println();

        // Teste 3: Demonstrando crescimento automático
        System.out.println("3. Demonstrando Crescimento Automático (Desafio):");
        ContainerSimples<Double> containerDouble = new ContainerSimples<>();
        
        System.out.println("   Capacidade inicial: " + containerDouble.capacidade());
        
        for (int i = 1; i <= 25; i++) {
            containerDouble.adicionar(i * 1.5);
            
            // Mostra quando o array cresce
            if (i == 10 || i == 20 || i == 25) {
                System.out.println("   Após " + i + " adições: Tamanho=" + containerDouble.tamanho() + 
                                   " | Capacidade=" + containerDouble.capacidade());
            }
        }
        System.out.println("   Crescimento automático: " + 10 + " → " + 20 + " → " + 40 + " (dobrando cada vez!)");
        System.out.println();

        // Teste 4: Comportamento LIFO (Last In, First Out)
        System.out.println("4. Comportamento LIFO - Pilha (Last In, First Out):");
        ContainerSimples<String> pilha = new ContainerSimples<>();
        
        String[] livros = {"Clean Code", "Design Patterns", "Effective Java"};
        System.out.println("   Adicionando: " + java.util.Arrays.toString(livros));
        for (String livro : livros) {
            pilha.adicionar(livro);
        }
        
        System.out.println("   Removendo (ordem inversa - LIFO):");
        while (!pilha.estaVazio()) {
            System.out.println("   └─ " + pilha.remover());
        }
        System.out.println();

        // Teste 5: Tratamento de erro
        System.out.println("5. Testando Erro - Remover de Container Vazio:");
        ContainerSimples<String> containerVazio = new ContainerSimples<>();
        try {
            containerVazio.remover();
        } catch (IllegalStateException e) {
            System.out.println("   ❌ Exceção capturada: " + e.getMessage());
        }
    }
}
