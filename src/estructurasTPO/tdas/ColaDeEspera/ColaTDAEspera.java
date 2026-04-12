package estructurasTPO.tdas.ColaDeEspera;

public interface ColaTDAEspera {
    void InicializarCola();  // pre: no aplica.
    void Acolar(int dni);  // pre: cola inicializada.
    void Desacolar();  // pre: cola inicializada y no vacia.
    boolean ColaVacia();  // pre: cola inicializada.
    int Primero();  // pre: cola inicializada y no vacia.
}

