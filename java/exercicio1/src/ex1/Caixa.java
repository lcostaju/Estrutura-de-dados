package ex1;
public class Caixa<T> implements Armazenavel<T> {
    private T item;

    @Override
    public void guardar(T item) {
        this.item = item;
    }

    @Override
    public T recuperar() {
        return this.item;
    }
}
