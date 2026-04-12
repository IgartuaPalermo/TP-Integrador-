package estructurasTPO.tdas.LibrosD;

public interface ConjuntoTDALibrosD {
    void InicializarConjunto();  // pre: no aplica.
    void Agregar(int isbn);  // pre: conjunto inicializado.
    int Elegir(); // pre: conjunto inicializado y no vacio.
    boolean ConjuntoVacio();  // pre: conjunto inicializado.
    void Sacar(int isbn);  // pre: conjunto inicializado.
    boolean Pertenece(int isbn);  // pre: conjunto inicializado.
}
