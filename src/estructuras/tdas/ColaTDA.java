package estructuras.tdas;

public interface ColaTDA {
    void InicializarCola();  // pre: no aplica.
    void Acolar(int x);  // pre: cola inicializada.
    void Desacolar();  // pre: cola inicializada y no vacia.
    boolean ColaVacia();  // pre: cola inicializada.
    int Primero();  // pre: cola inicializada y no vacia.
}

