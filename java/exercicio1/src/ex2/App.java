package ex2;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Testando Par<A, B> ===\n");

        // Teste 1: Par<String, Integer> para (nome, idade)
        System.out.println("1. Par<String, Integer> - Representando (nome, idade):");
        Par<String, Integer> pessoa1 = new Par<>("João Silva", 25);
        System.out.println("   Criado: " + pessoa1);
        System.out.println("   Primeiro (nome): " + pessoa1.getPrimeiro());
        System.out.println("   Segundo (idade): " + pessoa1.getSegundo());
        System.out.println();

        Par<String, Integer> pessoa2 = new Par<>("Maria Santos", 30);
        System.out.println("   Outro exemplo: " + pessoa2);
        System.out.println();

        // Teste 2: Par<String, Par<Integer, Double>> - Dados compostos
        System.out.println("2. Par<String, Par<Integer, Double>> - Dados compostos:");
        System.out.println("   Representando: (nome, (matricula, media))");
        
        Par<Integer, Double> notas = new Par<>(2024001, 8.5);
        Par<String, Par<Integer, Double>> aluno = new Par<>("Carlos Oliveira", notas);
        
        System.out.println("   Criado: " + aluno);
        System.out.println("   Primeiro (nome): " + aluno.getPrimeiro());
        System.out.println("   Segundo (matricula, media): " + aluno.getSegundo());
        System.out.println("   └─ Matrícula: " + aluno.getSegundo().getPrimeiro());
        System.out.println("   └─ Média: " + aluno.getSegundo().getSegundo());
        System.out.println();

        // Outro exemplo de dados compostos
        System.out.println("3. Outro exemplo de dados compostos:");
        System.out.println("   Representando: (produto, (quantidade, preco))");
        
        Par<Integer, Double> estoque = new Par<>(50, 29.99);
        Par<String, Par<Integer, Double>> produto = new Par<>("Notebook", estoque);
        
        System.out.println("   Criado: " + produto);
        System.out.println("   Produto: " + produto.getPrimeiro());
        System.out.println("   Quantidade: " + produto.getSegundo().getPrimeiro());
        System.out.println("   Preço: R$ " + produto.getSegundo().getSegundo());
    }
}
