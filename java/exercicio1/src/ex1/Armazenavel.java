package ex1;
public interface Armazenavel<T> {
    void guardar(T item);
    T recuperar();
}
