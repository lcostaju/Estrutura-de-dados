package ex2;

public class Par<A, B> {
    private A primeiro;
    private B segundo;

    // Construtor
    public Par(A primeiro, B segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    // Obtém o primeiro valor
    public A getPrimeiro() {
        return primeiro;
    }

    // Obtém o segundo valor
    public B getSegundo() {
        return segundo;
    }

    // Representação legível do Par
    @Override
    public String toString() {
        return "(" + primeiro + ", " + segundo + ")";
    }
}
