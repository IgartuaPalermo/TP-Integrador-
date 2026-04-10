package tda.conjuntos;

public interface ConjuntoTDA {
    void InicializarConjunto();  // pre: no aplica.
    void AgregarElemento(int x);  // pre: conjunto inicializado.
    void EliminarElemento(int x);  // pre: conjunto inicializado.
    boolean Pertenece(int x);  // pre: conjunto inicializado.
    boolean ConjuntoVacio();  // pre: conjunto inicializado.
}
